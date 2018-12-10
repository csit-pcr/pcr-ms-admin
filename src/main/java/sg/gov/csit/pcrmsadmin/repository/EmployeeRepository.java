package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Long> {

}