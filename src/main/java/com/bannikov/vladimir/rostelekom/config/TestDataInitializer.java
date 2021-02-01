package com.bannikov.vladimir.rostelekom.config;

import com.bannikov.vladimir.rostelekom.model.Cluster;
import com.bannikov.vladimir.rostelekom.repository.ClusterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class TestDataInitializer implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(TestDataInitializer.class);

    private final ClusterRepository clusterRepository;

    public TestDataInitializer(ClusterRepository clusterRepository) {
        this.clusterRepository = clusterRepository;
    }

    @Override
    public void run(String... args) {
        clusterRepository.saveAndFlush(new Cluster(1L,"qwerty1"));
    }
}
