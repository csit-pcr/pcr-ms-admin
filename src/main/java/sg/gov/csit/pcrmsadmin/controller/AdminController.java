package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Admin;
import sg.gov.csit.pcrmsadmin.model.Section;
import sg.gov.csit.pcrmsadmin.model.EmployeeDTO;
import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import sg.gov.csit.pcrmsadmin.repository.*;

import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*") //This allows access to the frontend with any origin
@RequestMapping("/api")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    SectionRepository sectionRepository;

    // Get All Admins
    @GetMapping("/admin")
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody EmployeeDTO employee) {
        Admin admin = new Admin();

        admin.setEmployeeID(employee.getEmployeeID());
        admin.setAdminID(employee.getAdminID());
        return adminRepository.save(admin);
    }

    @GetMapping("/admin/{id}")
    public Admin getAdminById(@PathVariable(value = "id") Long adminId) {
        return adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "adminid", adminId));
    }

    // Update a Note
    @PutMapping("/admin/{id}")
    public Admin updateAdmin(@PathVariable(value = "id") Long adminId,
            @Valid @RequestBody Admin adminDetails) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "adminid", adminId));

        admin.setName(adminDetails.getName());
        admin.setSection(adminDetails.getSection());

        Admin updatedAdmin = adminRepository.save(admin);

        return updatedAdmin;
    }

    // Delete a Note
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteAdmin(@PathVariable(value = "id") Long adminId) {
        Admin admin = adminRepository.findById(adminId)
                .orElseThrow(() -> new ResourceNotFoundException("Admin", "adminId", adminId));

        adminRepository.delete(admin);

        return ResponseEntity.ok().build();

    }

}