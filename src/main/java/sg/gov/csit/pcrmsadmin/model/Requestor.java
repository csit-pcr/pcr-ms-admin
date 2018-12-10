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
@Table(name="Requestor")
@EntityListeners(AuditingEntityListener.class)
public class Requestor extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestor_id;

    //Mapping to Change Request <entity> - Child 
    // @OneToOne(mappedBy="fk_requestor_id", cascade = CascadeType.ALL)
    // private Set <ChangeRequest> requests;

    public Long getRequestorID() {
        return this.requestor_id;
    }

    public void setRequestorID(Long requestorID) {
        this.requestor_id = requestorID;
    }


}