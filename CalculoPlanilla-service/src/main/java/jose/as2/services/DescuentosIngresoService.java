package jose.as2.services;

import jose.as2.entities.BonificacionTiempoServicioEntity;
import jose.as2.entities.DescuentosIngresoEntity;
import jose.as2.repositories.DescuentoIngresoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentosIngresoService {
    @Autowired
    DescuentoIngresoRepository descuentoIngresoRepository;

    public List<DescuentosIngresoEntity> getAll(){
        return (List<DescuentosIngresoEntity>) descuentoIngresoRepository.findAll();
    }
}
