//FIXME - Refer to https://vladmihalcea.com/the-best-way-to-use-entity-inheritance-with-jpa-and-hibernate/

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

    private Long approver_id;
    
    // @ManyToOne
    // @JoinColumn(name = "cluster_assigned_ID")
    // private Cluster cluster_assigned;

    
    @OneToOne
    @JoinColumn(name = "section_assigned_ID")
    private Section section_assigned;
    
    // Start of Getters

    public Long getApproverID() {
        return this.approver_id;
    }

    // public Cluster getClusterAssigned() {
    //     return this.cluster_assigned;
    // }

    public Section getSectionAssigned() {
        return this.section_assigned;
    }

    // Start of Setters

    public void setApproverID(Long ID) {
        this.approver_id = ID;
    }

    // public void setClusterAssigned(Cluster clusterAssigned) {
    //     this.cluster_assigned = clusterAssigned;
    // }


    public void setSectionAssigned(Section sectionAssigned) {
        this.section_assigned = sectionAssigned;
    }

}