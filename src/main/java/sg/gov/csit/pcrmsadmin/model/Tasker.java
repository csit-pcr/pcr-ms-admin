package sg.gov.csit.pcrmsadmin.model;

//Classes imported or used
import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

@Entity
@Table(name="Tasker")
@EntityListeners(AuditingEntityListener.class)
public class Tasker extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tasker_id ;

    private String[] directorate_assigned;

    private String[] section_assigned;

    //Mapping to Change Request <entity> - Child 
    // @OneToOne(mappedBy="fk_tasker_id", cascade = CascadeType.ALL)
    // private Set <ChangeRequest> requests;

    //Start of Getters

    public Long getTaskerID() {
        return this.tasker_id;
    }    

    public String[] getDirectorateAssigned() {
        return this.directorate_assigned;
    }

    public String[] getSectionAssigned() {
        return this.section_assigned;
    }

    //Start of Setters

    public void setTaskerID(Long taskerID) {
        this.tasker_id = taskerID;
    }

    public void setDirectorateAssigned(String[] directorateAssigned) {
        this.directorate_assigned = directorateAssigned;
    }

    public void setSectionAssigned(String[] sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }


}