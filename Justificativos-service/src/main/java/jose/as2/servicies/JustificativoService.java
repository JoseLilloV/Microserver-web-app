package jose.as2.servicies;

import javassist.expr.NewArray;
import jose.as2.entities.JustificativoEntity;
import jose.as2.repositories.JustificativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class JustificativoService {
    @Autowired
    JustificativoRepository justificativoRepository;

    public JustificativoEntity guardar(JustificativoEntity nuevo_justificativo){
        return justificativoRepository.save(nuevo_justificativo);
    }

    public List<JustificativoEntity> getAllbyMes(String mes) throws ParseException {
        Iterable<JustificativoEntity> all  = justificativoRepository.findAll();
        List<JustificativoEntity> salida = new LinkedList<>();
        String date_string =  mes+"-1-2022";
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        //Parsing the given String to Date object
        //LocalDate date1 = LocalDate.of(2014, 9, 11)
        Date primero = formatter.parse(date_string);
        for (JustificativoEntity registro : all) {
            if(registro.getFecha().compareTo(primero)>=0){
                salida.add(registro);
            }
        }
        return salida;
    }

}
