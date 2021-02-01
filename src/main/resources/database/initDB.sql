CREATE TABLE clusters (
    id_cluster BIGINT NOT NULL AUTO_INCREMENT,
    cluster_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (id_cluster)
);

CREATE TABLE node (
    ip   BIGINT NOT NULL AUTO_INCREMENT,
    node_name VARCHAR(200) NOT NULL,
    PRIMARY KEY (ip)
);
