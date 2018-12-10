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
@Table(name="Taskee")
@EntityListeners(AuditingEntityListener.class)
public class Taskee extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskee_id ;

    //Mapping to Change Request <entity> - Child 
    // @OneToOne(mappedBy="fk_taskee_id", cascade = CascadeType.ALL)
    // private Set <ChangeRequest> requests;

    public Long getTaskerID() {
        return this.taskee_id;
    }

    public void setTaskerID(Long taskerID) {
        this.taskee_id = taskerID;
    }


}