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
import java.util.Date;


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

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valid_from;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valid_to;

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

    public Date getValidFrom() {
        return this.valid_from;
    }

    public Date getValidTo() {
        return this.valid_to;
    }

    //Start of Setters

    public void setSectionID(Long sectionID) {
        this.section_id = sectionID;
    }

    public void setSectionName(String sectionName) {
        this.section_name = sectionName;
    }

    public void setValidFrom(Date validFrom) {
        this.valid_from = validFrom;
    }

    public void setValidTo(Date validTo) {
        this.valid_to = validTo;
    }



}