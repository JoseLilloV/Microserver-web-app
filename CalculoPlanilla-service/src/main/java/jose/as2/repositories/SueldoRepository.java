package jose.as2.repositories;

import jose.as2.entities.SueldoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SueldoRepository extends CrudRepository<SueldoEntity, Long> {
}
