// package sg.gov.csit.pcrmsadmin.controller;

// // import sg.gov.csit.pcrmsadmin.exception.*;
// import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;
// import sg.gov.csit.pcrmsadmin.repository.*;
// import org.springframework.beans.factory.annotation.Autowired;
// // import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.bind.annotation.RestController;
// import javax.validation.Valid;
// import java.util.List;


// @RestController
// @RequestMapping("/api")
// public class EmployeeController {

//     @Autowired
//     EmployeeRepository employeeRepository;

//     // Get All Notes
//     @GetMapping("/emp")
//     public List<EmployeeDetails> getAllEmployees() {
//         return employeeRepository.findAll();
//     }

//     // Create a new Note
//     @PostMapping("/emp")
//     public EmployeeDetails createNote(@Valid @RequestBody EmployeeDetails employee) {
//         return employeeRepository.save(employee);
//     }


// }