package jose.as2.services;

import jose.as2.entities.BonificacionTiempoServicioEntity;
import jose.as2.entities.SueldoEntity;
import jose.as2.repositories.BonificacionTiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonificacionTiempoService {
    @Autowired
    BonificacionTiempoRepository bonificacionTiempoRepository;

    public List<BonificacionTiempoServicioEntity> getAll(){
        return (List<BonificacionTiempoServicioEntity>) bonificacionTiempoRepository.findAll();
    }
}

