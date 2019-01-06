//FIXME - Consider delete
package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Requestor;
import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.model.EmployeeDTO;
import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import sg.gov.csit.pcrmsadmin.repository.*;

// import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*") //This allows access to the frontend with any origin
@RequestMapping("/api")
public class RequestorController {

    @Autowired
    RequestorRepository requestorRepository;
    @Autowired
    SectionRepository sectionRepository;

    // Get All Notes
    @GetMapping("/requestor")
    public List<Requestor> getAllNotes() {
        return requestorRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/requestor")
    public Requestor createRequestor(@Valid @RequestBody EmployeeDTO employee) {
        Section section = sectionRepository.findById(employee.getSection()).get();
        Requestor requestor = new Requestor();

        requestor.setName(employee.getName());
        requestor.setEmployeeNo(employee.getEmployeeNo());
        requestor.setSection(section);
        return requestorRepository.save(requestor);
    }

    @GetMapping("/requestor/{id}")
    public Requestor getRequestorById(@PathVariable(value = "id") Long requestorId) {
        return requestorRepository.findById(requestorId)
                .orElseThrow(() -> new ResourceNotFoundException("Requestor", "requestorid", requestorId));
    }

    // Update a Note
    @PutMapping("/requestor/{id}")
    public Requestor updateRequestor(@PathVariable(value = "id") Long requestorId,
            @Valid @RequestBody Requestor requestorDetails) {
        Requestor requestor = requestorRepository.findById(requestorId)
                .orElseThrow(() -> new ResourceNotFoundException("Requestor", "requestorid", requestorId));

        requestor.setName(requestorDetails.getName());
        requestor.setSection(requestorDetails.getSection());

        Requestor updatedRequestor = requestorRepository.save(requestor);

        return updatedRequestor;
    }

    // Delete a Note
    @DeleteMapping("/requestor/{id}")
    public ResponseEntity<?> deleteRequestor(@PathVariable(value = "id") Long requestorId) {
        Requestor requestor = requestorRepository.findById(requestorId)
                .orElseThrow(() -> new ResourceNotFoundException("Requestor", "requestorId", requestorId));

        requestorRepository.delete(requestor);

        return ResponseEntity.ok().build();

    }

}