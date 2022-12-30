package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "planilla")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlanillaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Integer mes;
    private Integer anio;
    private String rut;
    private String apellidos;
    private String nombres;
    private Integer bonos_horas_extras;
    private Integer bonos_puntualidad;
    private Integer descuento_ingreso;
    private Integer descuento_salida;
    private Integer sueldo_bruto;
    private Integer contizacion_previsional;
    private Integer contizacion_salud;
    private Integer sueldo_liquido;


    public PlanillaEntity(Integer mes, int anio, String rut, String nombres, String apellidos,
                          int horasExtras, int puntualidad, float ingreso, float salida,
                          float sueldoBruto, float prevision, float salud, float sueldoLiquido) {
        this.mes = mes;
        this.anio= anio;
        this.rut= rut;
        this.apellidos= apellidos;
        this.nombres = nombres;
        this.bonos_horas_extras = horasExtras;
        this.bonos_puntualidad = puntualidad;
        this.descuento_ingreso = (int) ingreso;
        this.descuento_salida = (int)salida;
        this.sueldo_bruto = (int)sueldoBruto;
        this.contizacion_previsional =(int) prevision;
        this.contizacion_salud =(int) salud;
        this.sueldo_liquido = (int)sueldoLiquido;
    }
}