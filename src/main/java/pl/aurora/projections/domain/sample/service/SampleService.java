package pl.aurora.projections.domain.sample.service;

import lombok.RequiredArgsConstructor;
import pl.aurora.projections.domain.sample.integration.DynamicProjectionDTO;
import pl.aurora.projections.domain.sample.integration.NameOnlyDTO;
import pl.aurora.projections.domain.sample.model.SampleEntity;
import pl.aurora.projections.domain.sample.projection.NameOnly;
import pl.aurora.projections.domain.sample.repository.SampleSpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Tuple;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleService {

    private final SampleSpringDataRepository sampleRepository;

    public void init(int numberOfRows) {
        for (int i = 0; i < numberOfRows; i++) {
            sampleRepository.save(new SampleEntity((long) i + 1, "someName" + i, "someCity1" + i, i));
        }
    }

    public void testEntityProjection() {
        List<SampleEntity> projections = sampleRepository.findAll();
    }

    public void testConstructorProjection() {
        List<NameOnlyDTO> projections = sampleRepository.findAllNameOnlyConstructorProjection();
    }

    public void testInterfaceProjection() {
        List<NameOnly> projections = sampleRepository.findAllNameOnlyBy();
    }

    public void testTupleProjection() {
        List<Tuple> projections = sampleRepository.findAllNameOnlyTupleProjection();
    }

    public void testDynamicProjection() {
        List<DynamicProjectionDTO> projections = sampleRepository.findAllBy(DynamicProjectionDTO.class);
    }
}
