package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Cluster;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {

    //To find cluster by Name
    @Query("SELECT c FROM Cluster c WHERE UPPER(c.cluster_name) = UPPER(:cluster_name)")
    public Cluster findClusterByClusterName(String cluster_name);

    //To select all the cluster names that have not expired
    @Query("SELECT cluster_name FROM Cluster WHERE valid_to > GETDATE() ")
    public List<Cluster> findClusterNames();
}