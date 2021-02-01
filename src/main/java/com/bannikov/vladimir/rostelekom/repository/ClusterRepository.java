package com.bannikov.vladimir.rostelekom.repository;

import com.bannikov.vladimir.rostelekom.model.Cluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {
}
