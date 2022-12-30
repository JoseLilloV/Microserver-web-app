package jose.as2.repositories;

import jose.as2.entities.RelojEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelojRepository extends CrudRepository<RelojEntity, Long> {
    RelojEntity save(RelojEntity registro);
}
