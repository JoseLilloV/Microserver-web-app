package jose.as2.repositories;

import jose.as2.entities.DescuentosIngresoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoIngresoRepository extends CrudRepository<DescuentosIngresoEntity, Long> {
}
