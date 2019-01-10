package sg.gov.csit.pcrmsadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.gov.csit.pcrmsadmin.model.Tasker;

@Repository
public interface TaskerRepository extends JpaRepository<Tasker, Long> {
    
}