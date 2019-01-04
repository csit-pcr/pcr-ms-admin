package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Section;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    @Query("SELECT c FROM Section c WHERE UPPER(c.section_name) = UPPER(:section_name)")
    public Section findSectionBySectionName (String section_name);
}