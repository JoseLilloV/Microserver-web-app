package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bonificacion_puntualidad")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonificacionPuntualidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Integer porcentaje_ingreso_puntual;
    private Integer porcentaje_salida_puntual;
    private Integer bonificacion;
}
