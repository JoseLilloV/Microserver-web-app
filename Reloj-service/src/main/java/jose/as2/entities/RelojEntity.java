package jose.as2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Entity
@Table(name = "reloj")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RelojEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    private Date fecha;
    private int hora;
    private int minuto;
    private String  rut;

    public RelojEntity(String fecha_str, String hora_minuto, String rut) throws ParseException {
        this.fecha =new SimpleDateFormat("yyyy/MM/dd").parse(fecha_str);
        this.hora = Integer.parseInt(hora_minuto.split(":")[0]);
        this.minuto = Integer.parseInt(hora_minuto.split(":")[1]);
        this.rut = rut;
    }

}
