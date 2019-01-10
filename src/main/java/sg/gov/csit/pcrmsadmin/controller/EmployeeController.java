package sg.gov.csit.pcrmsadmin.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.persistence.CollectionTable;

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

import sg.gov.csit.pcrmsadmin.config.Roles;
import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import sg.gov.csit.pcrmsadmin.model.EmployeeDTO;
import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;
import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.repository.EmployeeRepository;
import sg.gov.csit.pcrmsadmin.repository.SectionRepository;

@RestController
@CrossOrigin(origins = "*") // This allows access to the frontend with any origin
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    SectionRepository sectionRepository;

    // Get All Employees
    @GetMapping("/employee")
    public List<EmployeeDetails> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/employee")
    public EmployeeDetails createEmployee(@Valid @RequestBody EmployeeDTO employee) {
        Section section = sectionRepository.findById(employee.getSection()).get();
        EmployeeDetails employeeDetails = new EmployeeDetails();

        employeeDetails.setName(employee.getName());
        employeeDetails.setEmployeeID(employee.getEmployeeID());
        employeeDetails.setRoles(employee.getRoles());

        employeeDetails.setSection(section);
        return employeeRepository.save(employeeDetails);
    }

    @GetMapping("/employee/{id}")
    public EmployeeDetails getEmployeeById(@PathVariable(value = "id") String employeeId) {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeid", employeeId));
    }

    @GetMapping("/employee/ids")
    public List<EmployeeDetails> getAllEmployeeIDs() {
        return employeeRepository.findEmployeeIDs();
    }

    // Update a Note
    @PutMapping("/employee/{id}")
    public EmployeeDetails updateEmployee(@PathVariable(value = "id") String employeeId,
            @Valid @RequestBody EmployeeDetails employeeDetails) {
        EmployeeDetails employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeid", employeeId));

        employee.setName(employeeDetails.getName());
        employee.setSection(employeeDetails.getSection());

        EmployeeDetails updatedEmployee = employeeRepository.save(employee);

        return updatedEmployee;
    }

    // Delete a Note
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") String employeeId) {
        EmployeeDetails employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", employeeId));

        employeeRepository.delete(employee);

        return ResponseEntity.ok().build();

    }

}