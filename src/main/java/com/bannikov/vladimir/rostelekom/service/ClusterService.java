package com.bannikov.vladimir.rostelekom.service;

import com.bannikov.vladimir.rostelekom.model.Cluster;
import com.bannikov.vladimir.rostelekom.model.dto.ClusterDto;

public interface ClusterService {

    Cluster saveNewCluster(ClusterDto clusterDto);

    void updateCluster(ClusterDto clusterDto, Long id);

    void deleteClusterById(Long idCluster);
}
