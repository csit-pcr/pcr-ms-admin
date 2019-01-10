package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Approver;
import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.model.EmployeeDTO;
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
    @Autowired
    SectionRepository sectionRepository;

    // Get All Approvers
    @GetMapping("/approver")
    public List<Approver> getAllApprovers() {
        return approverRepository.findAll();
    }

    // Create a new Approver
    @PostMapping("/approver")
    public Approver createApprover(@Valid @RequestBody EmployeeDTO employee) {
        Section sectionAssigned = sectionRepository.findById(employee.getSectionAssigned()).get();
        Approver approver = new Approver();

        approver.setEmployeeID(employee.getEmployeeID());
        approver.setApproverID(employee.getApproverID());
        approver.setSectionAssigned(sectionAssigned);

        return approverRepository.save(approver);
    }

    @GetMapping("/approver/{id}")
    public Approver getApproverById(@PathVariable(value = "id")  String employeeId) {
        return approverRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "employeeid", employeeId));
    }

    // Update a Note
    @PutMapping("/approver/{id}")
    public Approver updateApprover(@PathVariable(value = "id")  String employeeId,
            @Valid @RequestBody Approver approverDetails) {
        Approver approver = approverRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "approverid", employeeId));
        
        approver.setName(approverDetails.getName());
        approver.setEmployeeID(approverDetails.getEmployeeID());
        approver.setSectionAssigned(approverDetails.getSectionAssigned());
        approver.setSection(approverDetails.getSection());

        Approver updatedApprover = approverRepository.save(approver);

        return updatedApprover;
    }

    // Delete a Note
    @DeleteMapping("/approver/{id}")
    public ResponseEntity<?> deleteApprover(@PathVariable(value = "id") String employeeId) {
        Approver approver = approverRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "employeeId", employeeId));

        approverRepository.delete(approver);

        return ResponseEntity.ok().build();

    }
}