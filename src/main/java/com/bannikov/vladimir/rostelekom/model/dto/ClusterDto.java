package com.bannikov.vladimir.rostelekom.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Schema(description = "Сущность кластера")
public class ClusterDto {

    @NotNull
    @Positive
    private Long clusterId;

    @Schema(description = "Имя кластера", example = "Cluster Name")
    @NotEmpty
    private String name;

    public ClusterDto() {
    }

    public ClusterDto(@NotNull @Positive Long clusterId, @NotEmpty String name) {
        this.clusterId = clusterId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getClusterId() {
        return clusterId;
    }

    public void setClusterId(Long clusterId) {
        this.clusterId = clusterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClusterDto that = (ClusterDto) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
