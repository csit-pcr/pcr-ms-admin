package sg.gov.csit.pcrmsadmin.model;

//Classes imports
import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

@Entity
@Table(name = "Taskee")
// @IdClass(TaskeeID.class)
@EntityListeners(AuditingEntityListener.class)
public class Taskee extends EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long taskee_id ;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long employee_no;

    // Mapping to Change Request <entity> - Child
    // @OneToOne(mappedBy="fk_taskee_id", cascade = CascadeType.ALL)
    // private Set <ChangeRequest> requests;

    @EmbeddedId
    private TaskeeID id;

    // Start of Getters

    public TaskeeID getID() {
        return this.id;
    }

    // Start of Setters

    public void setID(TaskeeID ID) {
        this.id = ID;
    }

    // public Long getTaskerID() {
    // return this.taskee_id;
    // }

    // public void setTaskerID(Long taskerID) {
    // this.taskee_id = taskerID;
    // }

}