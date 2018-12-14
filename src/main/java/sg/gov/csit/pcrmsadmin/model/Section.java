package sg.gov.csit.pcrmsadmin.model;

//Classes imported or used
// import sg.gov.csit.pcrmsadmin.model.EmployeeDetails;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.HashSet;
// import java.util.Set;


@Entity
@Table(name="Section")
@EntityListeners(AuditingEntityListener.class)
public class Section implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long section_id;

    @ManyToOne
    @JoinColumn(name = "FK_cluster_ID")
    private Cluster cluster;

    private String section_name;

    //Start of Getters

    public Long getSectionID() {
        return this.section_id;
    }    
    public String getSectionName() {
        return this.section_name;
    }

    public Cluster getCluster() {
        return this.cluster;
    }

    //Start of Setters

    public void setSectionID(Long sectionID) {
        this.section_id = sectionID;
    }

    public void setSectionName(String sectionName) {
        this.section_name = sectionName;
    }


}