package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Assignee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepository extends JpaRepository<Assignee, Long> {

}