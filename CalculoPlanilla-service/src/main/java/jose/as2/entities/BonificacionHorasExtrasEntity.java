package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "descuento_horas_extras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BonificacionHorasExtrasEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String area;
    private String categoria;
    private Integer monto_x_hora;

}
