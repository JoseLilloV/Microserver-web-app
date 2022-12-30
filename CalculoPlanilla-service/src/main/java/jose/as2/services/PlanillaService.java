package jose.as2.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jose.as2.entities.*;
import jose.as2.models.HoraExtra;
import jose.as2.models.Justificos;
import jose.as2.models.Reloj;
import jose.as2.repositories.PlanillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class PlanillaService {
    @Autowired
    PlanillaRepository planillaRepository;
    @Autowired
    EmpleadoService empleadoService;
    @Autowired
    SueldoService sueldoService;
    @Autowired
    BonificacionTiempoService bonificacionTiempoService;
    @Autowired
    BonificacionHorasExtrasService bonificacionHorasExtrasService;
    @Autowired
    DescuentosIngresoService descuentosIngresoService;
    @Autowired
    DescuentoSalidaService descuentoSalidaService;
    @Autowired
    DescuentosLegalesService descuentosLegalesService;

    @Autowired
    RestTemplate restTemplate;

    private boolean diaHabil (int dia, int mes, int anio) {
        Calendar c = Calendar.getInstance();
        c.set(anio,mes,dia); // vairables int
        int aux =  c.get(Calendar.DAY_OF_WEEK);
        if(aux==Calendar.MONDAY ||
                aux==Calendar.TUESDAY ||
                aux==Calendar.WEDNESDAY ||
                aux==Calendar.THURSDAY  ||
                aux==Calendar.FRIDAY) {
            return  true;
        } else{
            return false;
        }
    }
    private static int numeroDeDiasMes(int mes){
        int numeroDias=-1;
        switch(mes){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias=31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias=30;
                break;
            case 2:
                numeroDias=28;
                break;
            }
        return numeroDias;
    }

    public List<PlanillaEntity> calularPlanilla(Integer mes) throws ParseException {
        final long MILLSECS_PER_YEAR = 24 * 60 * 60 * 1000;
        List<EmpleadoEntity> empleados_all = empleadoService.getAll();

        List<HoraExtra> horaExtra_mes_raw = restTemplate.getForObject("http://HoraExtra-service/HoraExtra/byMes/" + mes, List.class);
        ObjectMapper mapper = new ObjectMapper();
        List<HoraExtra> horaExtra_mes = mapper.convertValue(horaExtra_mes_raw, new TypeReference<List<HoraExtra>>() {
        });
        List<Reloj> relojes_mes_raw = restTemplate.getForObject("http://Reloj-service/Reloj/byMes/" + mes, List.class);
        List<Reloj> relojes_mes = mapper.convertValue(relojes_mes_raw, new TypeReference<List<Reloj>>() {
        });
        List<Justificos> justificativos_mes_raw = restTemplate.getForObject("http://Justificativos-service/Justificativos/byMes/" + mes, List.class);
        List<Justificos> justificativos_mes = mapper.convertValue(justificativos_mes_raw, new TypeReference<List<Justificos>>() {
        });

        List<SueldoEntity> sueldo_all = sueldoService.getAll();
        List<BonificacionTiempoServicioEntity> bonificacion_tiempo_all = bonificacionTiempoService.getAll();
        List<BonificacionHorasExtrasEntity> bonificacion_hora_extras_all = bonificacionHorasExtrasService.getAll();
        List<DescuentosIngresoEntity> descuento_ingreso_all = descuentosIngresoService.getAll();
        List<DescuentoSalidaEntity> descuento_salida_all = descuentoSalidaService.getAll();
        List<DescuentosLegalesEntity> descuentos_legales_all = descuentosLegalesService.getAll();
        int bonos_hora_extra;
        int sueldoBase;
        int bonficacionTiempoServicio;
        int descuento_inasistencia;
        float descuento_tardanza_ingreso;
        float descuento_salida_anticipada;
        int descueto_inasistencia;
        int bonos_puntualidad_entrada;
        int bonos_puntualidad_salida;
        float descuento_salud;
        float descuento_prevision;
        int bonos_puntualidad;


        int j, band, cont, temp;
        int anio_antiguedad;
        int index_entrada = 0;
        int index_salida = 0;
        float sueldo_bruto;
        float sueldo_final;
        String date_string = mes + "-01-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date primero_del_mes = formatter.parse(date_string);
        int cantidad_dias_mes = numeroDeDiasMes(mes);
        int dias_habil_mes;
        int descuentos_legales;
        long delta_year;
        Date hoy = new Date();
        Date dia_k;
        for (int i = 0; i < empleados_all.size(); i++) {
            // sueldo base
            j = 0;
            band = 0;
            while (band == 0) {
                if (sueldo_all.get(j).getArea().equals(empleados_all.get(i).getArea_trabajo()) &&
                        sueldo_all.get(j).getCategoria().equals(empleados_all.get(i).getCategoria())) {
                    band = 1;
                } else {
                    j++;
                }
            }
            sueldoBase = sueldo_all.get(j).getSueldo_fijo_mensual();

            //bonos horas extras
            j = 0;
            cont = 0;
            bonos_hora_extra = 0;
            while (j < horaExtra_mes.size()) {
                if (horaExtra_mes.get(j).getRut().equals(empleados_all.get(i).getRut())) {
                    cont += horaExtra_mes.get(j).getCantidad();
                }
                j++;
            }
            if (cont > 0) {
                j = 0;
                band = 0;
                while (band == 0) {
                    if (bonificacion_hora_extras_all.get(j).getArea().equals(empleados_all.get(i).getArea_trabajo()) &&
                            bonificacion_hora_extras_all.get(j).getCategoria().equals(empleados_all.get(i).getCategoria())) {
                        band = 1;
                    } else {
                        j++;
                    }
                }
                bonos_hora_extra = cont * bonificacion_hora_extras_all.get(j).getMonto_x_hora();
            }


            //bonos tiempo de servicio
            anio_antiguedad = (int) ((hoy.getTime() - empleados_all.get(i).getFecha_ingreso().getTime()) / MILLSECS_PER_YEAR / 365);
            j = 0;
            band = 0;

            while (band == 0) {
                if (anio_antiguedad < bonificacion_tiempo_all.get(j).getAnios_menor_que() &&
                        anio_antiguedad > bonificacion_tiempo_all.get(j).getAnios_mayor_que()) {
                    band = 1;
                } else {
                    j++;
                }
            }
            bonficacionTiempoServicio = bonificacion_tiempo_all.get(j).getBonificacion();

            j = 0;
            band = 0;

            while (band == 0) {
                if (anio_antiguedad < bonificacion_tiempo_all.get(j).getAnios_menor_que() &&
                        anio_antiguedad > bonificacion_tiempo_all.get(j).getAnios_mayor_que()) {
                    band = 1;
                } else {
                    j++;
                }
            }
            bonficacionTiempoServicio = bonificacion_tiempo_all.get(j).getBonificacion();

            //Descuento Legales

            j = 0;
            band = 0;
            while (band == 0) {
                if ( (2022-anio_antiguedad) < descuentos_legales_all.get(j).getAnio_menor_que() &&
                        (2022-anio_antiguedad) > descuentos_legales_all.get(j).getAnio_mayor_que()) {
                    band = 1;
                } else {
                    j++;
                }
            }
            descuento_prevision = descuentos_legales_all.get(j).getPrevisional();
            descuento_salud = descuentos_legales_all.get(j).getPlan_salud();

            descuento_inasistencia = 0;
            descuento_tardanza_ingreso = 0;
            bonos_puntualidad_entrada = 0;
            bonos_puntualidad_salida = 0;
            descuento_salida_anticipada =0;
            descueto_inasistencia = 0;
            dias_habil_mes = 0;
            Integer k = 0;
            for (k = 1; k <= cantidad_dias_mes; k++) {
                if (diaHabil(k, mes, 2022)) {
                    dias_habil_mes += 1;
                    j = 0;
                    temp = 0;
                    while (j < justificativos_mes.size() && band == 1) {
                        date_string = mes.toString() + "-" + k.toString() + "-2022";
                        dia_k = formatter.parse(date_string);
                        if (justificativos_mes.get(j).getRut().equals(empleados_all.get(i).getRut()) &&
                                justificativos_mes.get(j).getFecha().equals(dia_k)) {
                            temp = 1;
                        } else {
                            j++;
                        }
                    }
                    if (temp == 0) {//no justificado
                        j = 0;
                        band = 0;
                        index_entrada = 0;
                        index_salida = 0;
                        date_string = mes.toString() + "-" + k.toString() + "-2022";
                        dia_k = formatter.parse(date_string);
                        while (band != 2 && j < relojes_mes.size()) {
                            if (relojes_mes.get(j).getRut().equals(empleados_all.get(i).getRut()) &&
                                    relojes_mes.get(j).getFecha().equals(dia_k)) {
                                band++;
                                if (band == 1) {
                                    index_entrada = j;
                                } else {
                                    index_salida = j;
                                }
                            }
                            j++;
                        }

                        if (band < 2) {
                            descuento_inasistencia += 15;
                        }
                    } else {
                        //verificar orden correcto
                        if (relojes_mes.get(index_entrada).getHora() > relojes_mes.get(index_salida).getHora()) {
                            int temp_2 = index_entrada;
                            index_entrada = index_salida;
                            index_salida = temp_2;
                        }
                        //verificar puntualidad y descuento por tardanza ingreso
                        //desde las 08:00 hrs hasta las 18:00
                        j = descuento_ingreso_all.size() - 1;
                        band = 0;
                        while (band == 0 && j >= 0) {
                            if (descuento_ingreso_all.get(j).getTiempo_mayor_que() >= 60) {
                                if (descuento_ingreso_all.get(j).getTiempo_mayor_que() - 60 < relojes_mes.get(index_entrada).getMinuto() &&
                                        8 + descuento_ingreso_all.get(j).getTiempo_mayor_que() / 60 <= relojes_mes.get(index_entrada).getHora() ) {
                                    band = 2;
                                } else {
                                    j++;
                                }
                            } else {
                                if (descuento_ingreso_all.get(j).getTiempo_mayor_que() < relojes_mes.get(index_entrada).getMinuto()) {
                                    band = 1;
                                } else {
                                    j++;
                                }
                            }
                        }
                        if (band == 1) {
                            descuento_tardanza_ingreso += descuento_ingreso_all.get(j).getDescuento();
                        } else if (band == 2) {
                            descueto_inasistencia += 15;
                        } else {
                            if (relojes_mes.get(index_entrada).getMinuto() == 0 &&
                                    relojes_mes.get(index_entrada).getHora() == 8) {
                                bonos_puntualidad_entrada += 1;
                            }
                        }
                        //descuento por salida
                        j = descuento_salida_all.size() - 1;
                        band = 0;
                        descuento_salida_anticipada = 0;
                        while (band == 0 && j >= 0) {
                            if (relojes_mes.get(index_entrada).getHora() == 17 &&
                                    descuento_salida_all.get(j).getTiempo_mayor_que() < relojes_mes.get(index_entrada).getMinuto() &&
                                    relojes_mes.get(index_entrada).getMinuto() <= descuento_salida_all.get(j).getTiempo_menor_que()) {
                                if (descuento_salida_all.get(j).getJustificativo()) {
                                    band = 2;
                                } else {
                                    band = 1;
                                }
                            } else {
                                j++;
                            }

                        }
                        if (band == 1) {
                            descuento_salida_anticipada += descuento_salida_all.get(j).getDescuento();
                        } else  {
                            descueto_inasistencia += 15;
                        }

                    }


                }

            }
            descuento_prevision=sueldoBase*(descuento_prevision/100);
            descuento_salud=sueldoBase*(descuento_salud/100);

            descuento_salida_anticipada=sueldoBase*(descuento_salida_anticipada/100);
            descuento_tardanza_ingreso=sueldoBase*(descuento_tardanza_ingreso/100);
            bonos_puntualidad=0;
            sueldo_bruto = (sueldoBase+bonos_hora_extra+bonos_puntualidad)-(descuento_salida_anticipada+descuento_tardanza_ingreso);
            sueldo_final = sueldo_bruto - (descuento_prevision + descuento_salud);

            planillaRepository.save(new PlanillaEntity( mes,2022, empleados_all.get(i).getRut(),
                    empleados_all.get(i).getNombres(), empleados_all.get(i).getApellidos(),
                    bonos_hora_extra, bonos_puntualidad, descuento_tardanza_ingreso, descuento_salida_anticipada,
                    sueldo_bruto,  descuento_prevision,  descuento_salud,sueldo_final));
        }

        return null;
    }




    public  List<PlanillaEntity> byMes(int mes){
        return planillaRepository.findByMes(mes);
    }



}


