package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "descuento_legales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DescuentosLegalesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private  Integer anio_menor_que;
    private Integer anio_mayor_que;
    private  Integer previsional;
    private  Integer plan_salud;



}
