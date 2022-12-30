package jose.as2.services;

import jose.as2.entities.BonificacionHorasExtrasEntity;
import jose.as2.entities.BonificacionTiempoServicioEntity;
import jose.as2.repositories.BonificacionHorasExtrasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonificacionHorasExtrasService {
    @Autowired
    BonificacionHorasExtrasRepository bonificacionHorasExtrasRepository;

    public List<BonificacionHorasExtrasEntity> getAll(){
        return (List<BonificacionHorasExtrasEntity>) bonificacionHorasExtrasRepository.findAll();
    }
}
