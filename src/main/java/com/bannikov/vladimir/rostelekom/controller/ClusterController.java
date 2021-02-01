package com.bannikov.vladimir.rostelekom.controller;

import com.bannikov.vladimir.rostelekom.config.ApiVersion;
import com.bannikov.vladimir.rostelekom.model.dto.ClusterDto;
import com.bannikov.vladimir.rostelekom.service.ClusterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.bannikov.vladimir.rostelekom.controller.ClusterController.BASE_URL;
import static com.bannikov.vladimir.rostelekom.util.WebUtil.getFullRequestUri;

@RestController
@Slf4j
@Tag(name = "Crud-контроллер", description = "Контроллер позволяет создавать, изменять и удалять кластеры")
@RequestMapping(BASE_URL)
public class ClusterController {

    public static final String BASE_URL = ApiVersion.VERSION_1_0 + "/clusters";

    private final ClusterService clusterService;

    public ClusterController(ClusterService clusterService) {
        this.clusterService = clusterService;
    }

    @PostMapping
    @Validated
    @Operation(
            summary = "Создание кластера",
            description = "Позволяет создавать кластер")
    public ResponseEntity<Void> addCluster(
            @RequestBody @Valid @Parameter(description = "Сущность кластера для записи в БД") ClusterDto clusterDto) {
        clusterService.saveNewCluster(clusterDto);
        log.debug("Received POST request to add new cluster, request URI:[{}]", getFullRequestUri());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @Validated
    @Operation(
            summary = "Изменение кластера",
            description = "Позволяет изменять кластер")
    public ResponseEntity<Void> editCluster(
            @PathVariable("id") @Parameter(description = "Идентификатор кластера") Long id,
            @RequestBody @Valid @Parameter(description = "Сущность кластера для изменения в БД") ClusterDto clusterDto,
            BindingResult bindingResult) {
        clusterService.updateCluster(clusterDto, id);
        log.debug("Received PUT request to edit cluster, request URI:[{}]", getFullRequestUri());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @Validated
    @Operation(
            summary = "Удаление кластера",
            description = "Позволяет удалять кластер")
    public void deleteCluster(
            @PathVariable("id") @Parameter(description = "Идентификатор кластера") Long id) {
        clusterService.deleteClusterById(id);
        log.debug("Received DELETE request to delete cluster, request URI:[{}]", getFullRequestUri());
    }
}
