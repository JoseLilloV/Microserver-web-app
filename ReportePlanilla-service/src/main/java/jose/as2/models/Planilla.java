package jose.as2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Planilla {
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
}
