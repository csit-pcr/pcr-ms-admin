package sg.gov.csit.pcrmsadmin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import sg.gov.csit.pcrmsadmin.model.Approver;
import sg.gov.csit.pcrmsadmin.model.EmployeeDTO;
import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.repository.ApproverRepository;
import sg.gov.csit.pcrmsadmin.repository.SectionRepository;

@RestController
@CrossOrigin(origins = "*") // This allows access to the frontend with any origin
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
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "employeeId", employeeId));
    }

    // Update a Note
    @PutMapping("/approver/{id}")
    public Approver updateApprover(@PathVariable(value = "id")  String employeeId,
            @Valid @RequestBody Approver approverDetails) {
        Approver approver = approverRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "employeeId", employeeId));
        
        approver.setSectionAssigned(approverDetails.getSectionAssigned());

        Approver updatedApprover = approverRepository.save(approver);

        return updatedApprover;
    }

    //Delete a Note
    @DeleteMapping("/approver/{id}")
    public ResponseEntity<?> deleteApprover(@PathVariable(value = "id") String employeeId) {
        Approver approver = approverRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Approver", "employeeId", employeeId));

        approverRepository.delete(approver);

        return ResponseEntity.ok().build();

    }

}