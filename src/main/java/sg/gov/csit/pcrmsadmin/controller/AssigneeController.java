//FIXME - Consider delete

package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Assignee;
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
@CrossOrigin(origins = "*") // This allows access to the frontend with any origin
@RequestMapping("/api")
public class AssigneeController {

    @Autowired
    AssigneeRepository assigneeRepository;
    @Autowired
    SectionRepository sectionRepository;

    // Get All Data
    @GetMapping("/assignee")
    public List<Assignee> getAllAssignees() {
        return assigneeRepository.findAll();
    }

    // Create a new assignee
    @PostMapping("/assignee")
    public Assignee createAssignee(@Valid @RequestBody EmployeeDTO employee) {
        Section section = sectionRepository.findById(employee.getSection()).get();
        Assignee assignee = new Assignee();

        assignee.setName(employee.getName());
        assignee.setEmployeeNo(employee.getEmployeeNo());
        assignee.setSection(section);

        return assigneeRepository.save(assignee);
    }

    // Search assignee by id
    @GetMapping("/assignee/{id}")
    public Assignee getAssigneeById(@PathVariable(value = "id") Long assigneeId) {
        return assigneeRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignee", "assigneeid", assigneeId));
    }

    // Update assignee details
    @PutMapping("/assignee/{id}")
    public Assignee updateAssignee(@PathVariable(value = "id") Long assigneeId, @Valid @RequestBody Assignee assigneeDetails) {
        Assignee assignee = assigneeRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignee", "assigneeid", assigneeId));

        assignee.setName(assigneeDetails.getName());
        assignee.setSection(assigneeDetails.getSection());

        Assignee updatedAssignee = assigneeRepository.save(assignee);

        return updatedAssignee;
    }

    // Delete a assignee
    @DeleteMapping("/assignee/{id}")
    public ResponseEntity<?> deleteAssignee(@PathVariable(value = "id") Long assigneeId) {
        Assignee assignee = assigneeRepository.findById(assigneeId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignee", "assigneeId", assigneeId));

        assigneeRepository.delete(assignee);

        return ResponseEntity.ok().build();

    }
}