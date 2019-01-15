package sg.gov.csit.pcrmsadmin.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, String> {

    // To select all the cluster names that have not expired
    @Query("SELECT employee_id FROM EmployeeDetails")
    public List<EmployeeDetails> findEmployeeIDs();

    // To retrieve all the section names
    @Query("SELECT name FROM EmployeeDetails")
    public List<EmployeeDetails> findEmployeeNames();
}