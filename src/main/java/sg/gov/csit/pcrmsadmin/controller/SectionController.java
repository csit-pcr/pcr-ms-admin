package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Section;
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
public class SectionController {

    @Autowired
    SectionRepository sectionRepository;

    // Get All Notes
    @GetMapping("/section")
    public List<Section> getAllNotes() {
        return sectionRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/section")
    public Section createCluster(@Valid @RequestBody Section section) {
        return sectionRepository.save(section);
    }

    @GetMapping("/section/{id}")
    public Section getSectionById(@PathVariable(value = "id") Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", "sectionid", sectionId));
    }

}