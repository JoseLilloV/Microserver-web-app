package jose.as2.services;

import jose.as2.entities.RelojEntity;
import jose.as2.repositories.RelojRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@Service
public class RelojService {
    @Autowired
    RelojRepository relojRepository;

    public List<RelojEntity> getAllByMes(String mes) throws ParseException {
        Iterable<RelojEntity> all =  relojRepository.findAll();
        List<RelojEntity> salida = new LinkedList<>();
        String date_string =  mes+"-1-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date primero = formatter.parse(date_string);
        for (RelojEntity registro: all) {
            if(registro.getFecha().compareTo(primero)>=0){
                salida.add(registro);
            }
        }
        return salida;
    }

    public RelojEntity guardar(RelojEntity registro){
        return relojRepository.save(registro);
    }
}
