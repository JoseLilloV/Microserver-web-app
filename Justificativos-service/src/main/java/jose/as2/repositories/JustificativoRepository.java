package jose.as2.repositories;

import jose.as2.entities.JustificativoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JustificativoRepository extends CrudRepository<JustificativoEntity, Long> {
}
