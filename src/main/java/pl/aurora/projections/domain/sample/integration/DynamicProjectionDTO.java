package pl.aurora.projections.domain.sample.integration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DynamicProjectionDTO {

    private String name;

    public DynamicProjectionDTO(String name) {
        this.name = name;
    }
}
