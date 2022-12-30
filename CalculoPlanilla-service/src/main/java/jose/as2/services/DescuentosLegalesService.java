package jose.as2.services;

import jose.as2.entities.DescuentosLegalesEntity;
import jose.as2.repositories.DescuentoLegalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DescuentosLegalesService {
    @Autowired
    DescuentoLegalesRepository descuentoLegalesRepository;

    List<DescuentosLegalesEntity> getAll(){
        return (List<DescuentosLegalesEntity>) descuentoLegalesRepository.findAll();
    }
}
