package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Cluster;
import sg.gov.csit.pcrmsadmin.repository.*;
import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") //This allows access to the frontend with any origin
@RequestMapping("/api")
public class ClusterController {

    @Autowired
    ClusterRepository clusterRepository;

    // Get All Clusters
    @GetMapping("/cluster")
    public List<Cluster> getAllClusters() {
        return clusterRepository.findAll();
    }

    //Get all Cluster Names that have not expired
    @GetMapping("/cluster/names")
    public List<Cluster> getAllClusterNames() {
        return clusterRepository.findClusterNames();
    }


    // Create a new Cluster
    @PostMapping("/cluster")
    public Cluster createCluster(@Valid @RequestBody Cluster cluster) {
        return clusterRepository.save(cluster);
    }

    @GetMapping("/cluster/{id}")
    public Cluster getClusterById(@PathVariable(value = "id") Long clusterId) {
        return clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "clusterid", clusterId));
    }

    @GetMapping("/cluster/ByName/{name}")
    public Cluster getClusterByName(@PathVariable(value = "name") String clusterName) {
        return clusterRepository.findClusterByClusterName(clusterName);
    }

    // Update a Note
    @PutMapping("/cluster/{id}")
    public Cluster updateCluster(@PathVariable(value = "id") Long clusterId,
            @Valid @RequestBody Cluster clusterDetails) {
        Cluster cluster = clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "clusterid", clusterId));

        cluster.setClusterName(clusterDetails.getClusterName());
        cluster.setValidFrom(clusterDetails.getValidFrom());
        cluster.setValidTo(clusterDetails.getValidTo());

        Cluster updatedCluster = clusterRepository.save(cluster);

        return updatedCluster;
    }

    // Delete a Note
    @DeleteMapping("/cluster/{id}")
    public ResponseEntity<?> deleteCluster(@PathVariable(value = "id") Long clusterId) {
        Cluster cluster = clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "clusterId", clusterId));

        clusterRepository.delete(cluster);

        return ResponseEntity.ok().build();

    }
}