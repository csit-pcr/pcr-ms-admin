package sg.gov.csit.pcrmsadmin.repository;

import sg.gov.csit.pcrmsadmin.model.Section;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionRepository extends JpaRepository<Section, Long> {

    //To find section by their name
    @Query("SELECT c FROM Section c WHERE UPPER(c.section_name) = UPPER(:section_name)")
    public Section findSectionBySectionName (String section_name);

    //To retrieve all the section's name that has not expired
    @Query("SELECT section_name FROM Section WHERE valid_to > GETDATE() ")
    public List<Section> findNonExpiredSectionNames();

    //To retrieve all the section names
    @Query("SELECT section_name FROM Section")
    public List<Section> findSectionNames();
}