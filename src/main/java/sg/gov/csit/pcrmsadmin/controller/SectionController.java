package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.model.Cluster;
import sg.gov.csit.pcrmsadmin.model.DeptDTO;
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
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;
    @Autowired
    ClusterRepository clusterRepository;

    // Get All Notes
    @GetMapping("/section")
    public List<Section> getAllSections() {
        return sectionRepository.findAll();
    }

    @GetMapping("/section/names")
    public List<Section> getAllSectionNames() {
        return sectionRepository.findSectionNames();
    }

    @PostMapping("/section")
    public Section createSection(@Valid @RequestBody DeptDTO dept ) {
        Cluster cluster = clusterRepository.findById(dept.getCluster()).get();
        Section section = new Section();

        section.setSectionName(dept.getSectionName());
        section.setCluster(cluster);
        section.setValidTo(dept.getValidTo());
        section.setValidFrom(dept.getValidFrom());

        return sectionRepository.save(section);
    }
    @GetMapping("/section/{id}")
    public Section getSectionById(@PathVariable(value = "id") Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", "sectionid", sectionId));
    }

    @GetMapping("/section/ByName/{name}")
    public Section getSectionByName(@PathVariable(value = "name") String sectionName) {
        return sectionRepository.findSectionBySectionName(sectionName);
    }

    // Update a Note
    @PutMapping("/section/{id}")
    public Section updateSection(@PathVariable(value = "id") Long sectionId,
            @Valid @RequestBody Section sectionDetails) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", "sectionid", sectionId));

        section.setSectionName(sectionDetails.getSectionName());
        section.setValidFrom(sectionDetails.getValidFrom());
        section.setValidTo(sectionDetails.getValidTo());

        Section updatedSection = sectionRepository.save(section);

        return updatedSection;
    }

    // Delete a Note
    @DeleteMapping("/section/{id}")
    public ResponseEntity<?> deleteSection(@PathVariable(value = "id") Long sectionId) {
        Section section = sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", "sectionId", sectionId));

        sectionRepository.delete(section);

        return ResponseEntity.ok().build();

    }
}