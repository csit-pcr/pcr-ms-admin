package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Approver;
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
public class ApproverController {

    @Autowired
    ApproverRepository approverRepository;

    // Get All Notes
    @GetMapping("/approver")
    public List<Approver> getAllNotes() {
        return approverRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/approver")
    public Approver createApprover(@Valid @RequestBody Approver approver) {
        return approverRepository.save(approver);
    }

    @GetMapping("/approver/{id}")
    public Approver getApproverById(@PathVariable(value = "id") Long approverId) {
        return approverRepository.findById(approverId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "approverid", approverId));
    }

    // Update a Note
    @PutMapping("/approver/{id}")
    public Approver updateApprover(@PathVariable(value = "id") Long approverId,
            @Valid @RequestBody Approver approverDetails) {
        Approver approver = approverRepository.findById(approverId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "approverid", approverId));
        
        approver.setName(approverDetails.getName());
        approver.setEmployeeNo(approverDetails.getEmployeeNo());
        approver.setSectionAssigned(approverDetails.getSectionAssigned());
        approver.setSection(approverDetails.getSection());

        Approver updatedApprover = approverRepository.save(approver);

        return updatedApprover;
    }

    // Delete a Note
    @DeleteMapping("/approver/{id}")
    public ResponseEntity<?> deleteApprover(@PathVariable(value = "id") Long approverId) {
        Approver approver = approverRepository.findById(approverId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "approverId", approverId));

        approverRepository.delete(approver);

        return ResponseEntity.ok().build();

    }
}