package jose.as2.services;

import com.netflix.discovery.converters.Auto;
import jose.as2.entities.SueldoEntity;
import jose.as2.repositories.SueldoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SueldoService {
    @Autowired
    SueldoRepository sueldoRepository;

    public List<SueldoEntity> getAll(){
        return (List<SueldoEntity>) sueldoRepository.findAll();
    }
}
