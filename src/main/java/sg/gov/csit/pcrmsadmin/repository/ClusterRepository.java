package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Cluster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {

    @Query("SELECT c FROM Cluster c WHERE UPPER(c.cluster_name) = UPPER(:cluster_name)")
    public Cluster findClusterByClusterName (String cluster_name);
}