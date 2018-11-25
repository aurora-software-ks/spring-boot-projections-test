package pl.aurora.projections.domain.sample.repository;

import pl.aurora.projections.domain.sample.integration.NameOnlyDTO;
import pl.aurora.projections.domain.sample.model.SampleEntity;
import pl.aurora.projections.domain.sample.projection.NameOnly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface SampleSpringDataRepository extends JpaRepository<SampleEntity, Long> {

    <T> List<T> findAllBy(Class<T> type);

    List<NameOnly> findAllNameOnlyBy();

    @Query("select new pl.aurora.projections.domain.sample.integration.NameOnlyDTO(e.name) from SampleEntity e")
    List<NameOnlyDTO> findAllNameOnlyConstructorProjection();

    @Query("select e.name as name from SampleEntity e")
    List<Tuple> findAllNameOnlyTupleProjection();

}
