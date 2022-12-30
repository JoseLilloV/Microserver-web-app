package jose.as2.repositories;

import jose.as2.entities.BonificacionHorasExtrasEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonificacionHorasExtrasRepository extends CrudRepository<BonificacionHorasExtrasEntity,Long> {
}
