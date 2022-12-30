package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "descuento_x_salida_tarde")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentoSalidaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Integer tiempo_mayor_que;
    private Integer tiempo_menor_que;
    private Integer descuento;
    private Boolean justificativo;
}
