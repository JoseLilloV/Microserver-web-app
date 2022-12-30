package jose.as2.services;

import jose.as2.entities.HoraExtraEntity;
import jose.as2.repositories.HoraExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class HoraExtraService {
    @Autowired
    HoraExtraRepository horaExtraRepository;

    public HoraExtraEntity guardar(HoraExtraEntity registro){
        return horaExtraRepository.save(registro);
    }


    public List<HoraExtraEntity> getAllbyMes(String mes) throws ParseException {
        Iterable<HoraExtraEntity> all  = horaExtraRepository.findAll();
        List<HoraExtraEntity> salida = new LinkedList<>();
        String date_string =  mes+"-1-2022";
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        Date primero = formatter.parse(date_string);

        for (HoraExtraEntity registro : all) {
            if(registro.getFecha().compareTo(primero)>=0){
                salida.add(registro);
            }
        }
        return salida;
    }
}
