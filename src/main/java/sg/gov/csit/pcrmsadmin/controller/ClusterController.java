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
@RequestMapping("/api")
public class ClusterController {

    @Autowired
    ClusterRepository clusterRepository;

    // Get All Notes
    @GetMapping("/cluster")
    public List<Cluster> getAllNotes() {
        return clusterRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/cluster")
    public Cluster createCluster(@Valid @RequestBody Cluster cluster) {
        return clusterRepository.save(cluster);
    }

    @GetMapping("/cluster/{id}")
    public Cluster getClusterById(@PathVariable(value = "id") Long clusterId) {
        return clusterRepository.findById(clusterId)
                .orElseThrow(() -> new ResourceNotFoundException("Cluster", "clusterid", clusterId));
    }

}