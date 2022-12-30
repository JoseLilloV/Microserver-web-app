package jose.as2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reloj {
    private Long id;
    private Date fecha;
    private int hora;
    private int minuto;
    private String  rut;
}
