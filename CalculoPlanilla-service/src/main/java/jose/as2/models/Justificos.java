package jose.as2.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Justificos {
    private Long id;
    private String rut;
    private Date fecha;
}
