package pl.aurora.projections.domain.sample.controller;

import lombok.RequiredArgsConstructor;
import pl.aurora.projections.domain.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sample")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SampleController {

    private final SampleService sampleService;

    private static final int OBJECTS_PER_ITERATION = 100000;
    private static final int ITERATIONS = 100;

    @GetMapping("/init")
    public void init() {
        sampleService.init(OBJECTS_PER_ITERATION);
    }

    @GetMapping("/test")
    public void testTimes() {
        List<Long> entityTimes = new ArrayList<>();
        List<Long> constructorTimes = new ArrayList<>();
        List<Long> interfaceTimes = new ArrayList<>();
        List<Long> tupleTimes = new ArrayList<>();
        List<Long> dynamicTimes = new ArrayList<>();

        for (int x = 0; x < ITERATIONS; x++) {
            //Entity projections
            long entityBefore = System.currentTimeMillis();
            sampleService.testEntityProjection();
            long entityAfter = System.currentTimeMillis();
            entityTimes.add(entityAfter - entityBefore);

            //Constructor projections
            long constructorBefore = System.currentTimeMillis();
            sampleService.testConstructorProjection();
            long constructorAfter = System.currentTimeMillis();
            constructorTimes.add(constructorAfter - constructorBefore);

            //Interface projections
            long interfaceBefore = System.currentTimeMillis();
            sampleService.testInterfaceProjection();
            long interfaceAfter = System.currentTimeMillis();
            interfaceTimes.add(interfaceAfter - interfaceBefore);

            //Tuple projections
            long tupleBefore = System.currentTimeMillis();
            sampleService.testTupleProjection();
            long tupleAfter = System.currentTimeMillis();
            tupleTimes.add(tupleAfter - tupleBefore);

            //Dynamic projections
            long dynamicBefore = System.currentTimeMillis();
            sampleService.testDynamicProjection();
            long dynamicAfter = System.currentTimeMillis();
            dynamicTimes.add(dynamicAfter - dynamicBefore);
        }

        System.out.println("Entity projections took " +
                entityTimes.stream().mapToDouble(x -> x).average().orElseThrow(IllegalArgumentException::new) +
                " ms on average out of " + ITERATIONS + " iterations.");
        System.out.println("Constructor projections took " +
                constructorTimes.stream().mapToDouble(x -> x).average().orElseThrow(IllegalArgumentException::new) +
                " ms on average out of " + ITERATIONS + " iterations.");
        System.out.println("Interface projections took " +
                interfaceTimes.stream().mapToDouble(x -> x).average().orElseThrow(IllegalArgumentException::new) +
                " ms on average out of " + ITERATIONS + " iterations.");
        System.out.println("Tuple projections took " +
                tupleTimes.stream().mapToDouble(x -> x).average().orElseThrow(IllegalArgumentException::new) +
                " ms on average out of " + ITERATIONS + " iterations.");
        System.out.println("Dynamic projections took " +
                dynamicTimes.stream().mapToDouble(x -> x).average().orElseThrow(IllegalArgumentException::new) +
                " ms on average out of " + ITERATIONS + " iterations.");
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("One iteration retrieved (from DB) and projected " + OBJECTS_PER_ITERATION + " objects.");
        System.out.println("-----------------------------------------------------------------------");
    }
}
