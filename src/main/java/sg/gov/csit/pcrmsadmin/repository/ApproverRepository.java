package sg.gov.csit.pcrmsadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import sg.gov.csit.pcrmsadmin.model.Approver;

@Repository
public interface ApproverRepository extends JpaRepository<Approver, String> {

}