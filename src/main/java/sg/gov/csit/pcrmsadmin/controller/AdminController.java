package sg.gov.csit.pcrmsadmin.controller;

import sg.gov.csit.pcrmsadmin.model.Admin;
import sg.gov.csit.pcrmsadmin.exception.ResourceNotFoundException;
import sg.gov.csit.pcrmsadmin.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class AdminController {

    @Autowired
    AdminRepository adminRepository;

    // Get All Notes
    @GetMapping("/admin")
    public List<Admin> getAllNotes() {
        return adminRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/admin")
    public Admin createAdmin(@Valid @RequestBody Admin admin) {
        return adminRepository.save(admin);
    }

    // @GetMapping("/admin/{id}")
    // public Admin getAdminById(@PathVariable(value = "id") Long adminId) {
    //     return adminRepository.findById(adminId)
    //             .orElseThrow(() -> new ResourceNotFoundException("Admin", "adminid", adminId));
    // }

}