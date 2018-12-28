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
@CrossOrigin(origins = "*") //This allows access to the frontend with any origin
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
    public Section createSection(@Valid @RequestBody Section section) {
        return sectionRepository.save(section);
    }

    @GetMapping("/section/{id}")
    public Section getSectionById(@PathVariable(value = "id") Long sectionId) {
        return sectionRepository.findById(sectionId)
                .orElseThrow(() -> new ResourceNotFoundException("Section", "sectionid", sectionId));
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