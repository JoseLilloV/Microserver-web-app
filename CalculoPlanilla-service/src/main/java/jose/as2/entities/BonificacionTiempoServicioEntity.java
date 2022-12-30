package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bonificacion_tiempo_servicio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonificacionTiempoServicioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Integer anios_menor_que;
    private Integer anios_mayor_que;
    private Integer bonificacion;

}
