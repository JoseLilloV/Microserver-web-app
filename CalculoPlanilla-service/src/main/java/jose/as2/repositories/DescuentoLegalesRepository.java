package jose.as2.repositories;

import jose.as2.entities.DescuentosLegalesEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescuentoLegalesRepository extends CrudRepository<DescuentosLegalesEntity, Long> {
}
