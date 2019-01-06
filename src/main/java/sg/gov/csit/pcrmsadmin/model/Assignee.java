//FIXME - To simplify, Consider deleting this model

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
@Table(name = "Assignee")
// @IdClass(AssigneeID.class)
@EntityListeners(AuditingEntityListener.class)
public class Assignee extends EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assignee_id ;

    //TODO - Consider creating default constructor and constructor that takes in Employee

    // Mapping to Change Request <entity> - Child
    // @OneToOne(mappedBy="fk_assignee_id", cascade = CascadeType.ALL)
    // private Set <ChangeRequest> requests;

    // Start of Getters

    public Long getAssigneeID() {
        return this.assignee_id;
    }

    // Start of Setters

    public void setAssigneeID(Long ID) {
        this.assignee_id = ID;
    }

}