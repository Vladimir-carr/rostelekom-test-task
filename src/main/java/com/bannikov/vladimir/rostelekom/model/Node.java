package com.bannikov.vladimir.rostelekom.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "NODE")
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ip;

    @Column(name = "node_name")
    private String nodeName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cluster", foreignKey = @ForeignKey(name = "node_to_claster"))
    @Cascade(CascadeType.ALL)
    @JsonBackReference
    private Cluster cluster;

    public Node() {
    }

    public Node(Long ip, String nodeName, Cluster cluster) {
        this.ip = ip;
        this.nodeName = nodeName;
        this.cluster = cluster;
    }

    public Long getIp() {
        return ip;
    }

    public void setIp(Long ip) {
        this.ip = ip;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(ip, node.ip) &&
                Objects.equals(nodeName, node.nodeName) &&
                Objects.equals(cluster, node.cluster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ip, nodeName, cluster);
    }
}
