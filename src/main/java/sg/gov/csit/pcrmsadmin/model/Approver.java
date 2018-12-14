package sg.gov.csit.pcrmsadmin.model;

//Classes that are imported or used
import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

@Entity
@Table(name = "Approver")
// @IdClass(ApproverID.class)
@EntityListeners(AuditingEntityListener.class)
public class Approver extends EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long approver_id;

    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    // private Long employee_no;
    @EmbeddedId
    private ApproverID id;

    private String[] cluster_assigned;

    private String[] section_assigned;

    // Start of Getters

    // public Long getApproverID() {
    // return this.approver_id;
    // }
    public ApproverID getID() {
        return this.id;
    }

    public String[] getClusterAssigned() {
        return this.cluster_assigned;
    }

    public String[] getSectionAssigned() {
        return this.section_assigned;
    }

    // Start of Setters

    // public void setApproverID(Long approverID) {
    // this.approver_id = approverID;
    // }

    // Start of Setters

    public void setID(ApproverID ID) {
        this.id = ID;
    }

    public void setClusterAssigned(String[] clusterAssigned) {
        this.cluster_assigned = clusterAssigned;
    }

    public void setSectionAssigned(String[] sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }

}