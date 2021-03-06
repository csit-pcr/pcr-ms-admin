package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Admin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

}