package jose.as2.repositories;

import jose.as2.entities.HoraExtraEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoraExtraRepository extends CrudRepository<HoraExtraEntity, Long> {
}
