package jose.as2.repositories;

import jose.as2.entities.PlanillaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlanillaRepository extends CrudRepository<PlanillaEntity, Long> {
    List<PlanillaEntity> findByMes(int mes);
}
