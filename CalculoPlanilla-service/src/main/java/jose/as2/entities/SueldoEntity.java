package jose.as2.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sueldo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SueldoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private String area;
    private String categoria;
    private Integer sueldo_fijo_mensual;

}