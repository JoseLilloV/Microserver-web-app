package jose.as2.repositories;

import jose.as2.entities.BonificacionTiempoServicioEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BonificacionTiempoRepository extends CrudRepository<BonificacionTiempoServicioEntity, Long> {

}
