package jose.as2.services;

import jose.as2.entities.DescuentoSalidaEntity;
import jose.as2.entities.DescuentosIngresoEntity;
import jose.as2.repositories.DescuentoSalidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentoSalidaService {
    @Autowired
    DescuentoSalidaRepository descuentoSalidaRepository;

    public List<DescuentoSalidaEntity> getAll(){
        return (List<DescuentoSalidaEntity>) descuentoSalidaRepository.findAll();
    }
}
