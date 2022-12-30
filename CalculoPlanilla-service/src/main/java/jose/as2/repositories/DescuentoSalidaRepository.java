package jose.as2.repositories;

import jose.as2.entities.DescuentoSalidaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoSalidaRepository extends CrudRepository<DescuentoSalidaEntity, Long> {
}
