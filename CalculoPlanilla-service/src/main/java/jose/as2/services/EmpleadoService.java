package jose.as2.services;

import jose.as2.entities.EmpleadoEntity;
import jose.as2.repositories.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService {
    @Autowired
    EmpleadoRepository empleadoRepository;

    public List<EmpleadoEntity> getAll(){
        return (List<EmpleadoEntity>) empleadoRepository.findAll();
    }

}
