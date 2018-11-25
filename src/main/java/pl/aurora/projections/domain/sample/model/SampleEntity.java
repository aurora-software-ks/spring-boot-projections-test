package pl.aurora.projections.domain.sample.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SAMPLE_ENTITIES")
public class SampleEntity {
    @Id
    private Long id;
    private String name;
    private String city;
    private Integer age;
}
