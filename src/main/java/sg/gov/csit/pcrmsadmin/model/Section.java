package sg.gov.csit.pcrmsadmin.model;

//Classes imported or used
import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Section")
@EntityListeners(AuditingEntityListener.class)
public class Section implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long section_id;

    private String section_name;

    // //Mapping to EmployeeDetails <entity> - Child 
    // @OneToOne(mappedBy="section_id", cascade = CascadeType.ALL)
    // private Set <EmployeeDetails> employees = new HashSet<>();

    //Start of Getters

    public Long getSectionID() {
        return this.section_id;
    }    
    public String getSectionName() {
        return this.section_name;
    }

    //Start of Setters

    public void setSectionID(Long sectionID) {
        this.section_id = sectionID;
    }

    public void setSectionName(String sectionName) {
        this.section_name = sectionName;
    }


}