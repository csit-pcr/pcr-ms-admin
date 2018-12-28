package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Taskee;
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
public class TaskeeController {

    @Autowired
    TaskeeRepository taskeeRepository;

    // Get All Data
    @GetMapping("/taskee")
    public List<Taskee> getAllTaskees() {
        return taskeeRepository.findAll();
    }

    // Create a new taskee
    @PostMapping("/taskee")
    public Taskee createTaskee(@Valid @RequestBody Taskee taskee) {
        return taskeeRepository.save(taskee);
    }

    // Search taskee by id
    @GetMapping("/taskee/{id}")
    public Taskee getApproverById(@PathVariable(value = "id") Long taskeeId) {
        return taskeeRepository.findById(taskeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Taskee", "taskeeid", taskeeId));
    }

    // Update taskee details
    @PutMapping("/taskee/{id}")
    public Taskee updateTaskee(@PathVariable(value = "id") Long taskeeId, @Valid @RequestBody Taskee taskeeDetails) {
        Taskee taskee = taskeeRepository.findById(taskeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Taskee", "taskeeid", taskeeId));

        taskee.setName(taskeeDetails.getName());
        taskee.setSection(taskeeDetails.getSection());

        Taskee updatedTaskee = taskeeRepository.save(taskee);

        return updatedTaskee;
    }

    // Delete a taskee
    @DeleteMapping("/taskee/{id}")
    public ResponseEntity<?> deleteTaskee(@PathVariable(value = "id") Long taskeeId) {
        Taskee taskee = taskeeRepository.findById(taskeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Taskee", "taskeeId", taskeeId));

        taskeeRepository.delete(taskee);

        return ResponseEntity.ok().build();

    }
}