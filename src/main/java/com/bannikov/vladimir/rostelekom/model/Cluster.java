package com.bannikov.vladimir.rostelekom.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLUSTERS")
public class Cluster {

    @Id
    @Column(name = "id_cluster")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCluster;

    @Column(name = "cluster_name")
    private String clusterName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cluster")
    @JsonManagedReference
    private List<Node> nodeList;

    public Cluster() {
    }

    public Cluster(Long idCluster, String clusterName) {
        this.idCluster = idCluster;
        this.clusterName = clusterName;
    }

    public Long getIdCluster() {
        return idCluster;
    }

    public void setIdCluster(Long idCluster) {
        this.idCluster = idCluster;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cluster cluster = (Cluster) o;
        return idCluster.equals(cluster.idCluster) &&
                clusterName.equals(cluster.clusterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCluster, clusterName);
    }
}
