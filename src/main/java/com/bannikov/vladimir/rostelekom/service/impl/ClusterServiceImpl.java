package com.bannikov.vladimir.rostelekom.service.impl;

import com.bannikov.vladimir.rostelekom.exception.ResourceNotFoundException;
import com.bannikov.vladimir.rostelekom.model.Cluster;
import com.bannikov.vladimir.rostelekom.model.dto.ClusterDto;
import com.bannikov.vladimir.rostelekom.repository.ClusterRepository;
import com.bannikov.vladimir.rostelekom.service.ClusterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.lang.String.format;

@Slf4j
@Service
public class ClusterServiceImpl implements ClusterService {

    private final ClusterRepository clusterRepository;

    public ClusterServiceImpl(ClusterRepository clusterRepository) {
        this.clusterRepository = clusterRepository;
    }

    @Override
    @Transactional
    public Cluster saveNewCluster(ClusterDto clusterDto) {
        Cluster cluster = clusterDtoToClusterMapping(clusterDto);
        Cluster savedCluster = clusterRepository.saveAndFlush(cluster);
        log.debug("In addNewCluster - Successfully saved new cluster:{}", cluster.getClusterName());
        return savedCluster;
    }

    @Override
    @Transactional
    public void updateCluster(ClusterDto clusterDto, Long id) {
        Cluster cluster = clusterDtoToClusterMapping(clusterDto);
        Optional<Cluster> byId = clusterRepository.findById(id);
        if (byId.isPresent()) {
            cluster.setIdCluster(id);
            clusterRepository.saveAndFlush(cluster);
            log.debug("In updateCluster - Successfully updated cluster with id:{}", cluster.getIdCluster());
        } else {
            throw new ResourceNotFoundException(
                    format("Failed to update cluster with name:%s: no cluster with given id:%s found", cluster.getClusterName(), cluster.getIdCluster()));
        }
    }

    @Override
    @Transactional
    public void deleteClusterById(Long idCluster) {
        Cluster cluster = clusterRepository.findById(idCluster).
                orElseThrow(() -> new ResourceNotFoundException(format("No cluster with given id:%s found", idCluster)));
        clusterRepository.delete(cluster);
        log.debug("In deleteCluster - Successfully deleted cluster with id:{}", idCluster);
    }

    private Cluster clusterDtoToClusterMapping(ClusterDto clusterDto) {
        Cluster cluster = new Cluster();
        cluster.setClusterName(clusterDto.getName());
        return cluster;
    }
}
