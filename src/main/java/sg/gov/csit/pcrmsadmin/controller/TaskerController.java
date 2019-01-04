package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Tasker;
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
public class TaskerController {

    @Autowired
    TaskerRepository taskerRepository;
    @Autowired
    SectionRepository sectionRepository;

    // Get All Data
    @GetMapping("/tasker")
    public List<Tasker> getAllTaskers() {
        return taskerRepository.findAll();
    }

    // Create a new tasker
    @PostMapping("/tasker")
    public Tasker createTasker(@Valid @RequestBody EmployeeDTO employee) {
        Section section = sectionRepository.findById(employee.getSection()).get();
        Section sectionAssigned = sectionRepository.findById(employee.getSectionAssigned()).get();
        Tasker tasker = new Tasker();

        tasker.setName(employee.getName());
        tasker.setEmployeeNo(employee.getEmployeeNo());
        tasker.setSection(section);
        tasker.setSectionAssigned(sectionAssigned);

        return taskerRepository.save(tasker);
    }


    // Search tasker by id
    @GetMapping("/tasker/{id}")
    public Tasker getTaskerById(@PathVariable(value = "id") Long taskerId) {
        return taskerRepository.findById(taskerId)
                .orElseThrow(() -> new ResourceNotFoundException("Tasker", "taskerid", taskerId));
    }

    // Update tasker details
    @PutMapping("/tasker/{id}")
    public Tasker updateTaskee(@PathVariable(value = "id") Long taskerId, @Valid @RequestBody Tasker taskerDetails) {
        Tasker tasker = taskerRepository.findById(taskerId)
                .orElseThrow(() -> new ResourceNotFoundException("Tasker", "taskerid", taskerId));

        tasker.setName(taskerDetails.getName());
        tasker.setSection(taskerDetails.getSection());

        Tasker updatedTasker = taskerRepository.save(tasker);

        return updatedTasker;
    }

    // Delete a tasker
    @DeleteMapping("/tasker/{id}")
    public ResponseEntity<?> deleteTasker(@PathVariable(value = "id") Long taskerId) {
        Tasker tasker = taskerRepository.findById(taskerId)
                .orElseThrow(() -> new ResourceNotFoundException("Tasker", "taskerId", taskerId));

        taskerRepository.delete(tasker);

        return ResponseEntity.ok().build();

    }
}