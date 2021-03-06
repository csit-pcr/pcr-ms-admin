package sg.gov.csit.pcrmsadmin.model;

//Spring imports
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Java imports
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Cluster")
@EntityListeners(AuditingEntityListener.class)
public class Cluster implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cluster_id;

    private String cluster_name;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valid_from;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date valid_to;

    //Start of Getters

    public Long getClusterID() {
        return this.cluster_id;
    }    

    public String getClusterName() {
        return this.cluster_name;
    }

    public Date getValidFrom() {
        return this.valid_from;
    }

    public Date getValidTo() {
        return this.valid_to;
    }

    //Start of Setters

    public void setClusterID(Long clusterID) {
        this.cluster_id = clusterID;
    }

    public void setClusterName(String clusterName) {
        this.cluster_name = clusterName;
    }

    public void setValidFrom(Date validFrom) {
        this.valid_from = validFrom;
    }

    public void setValidTo(Date validTo) {
        this.valid_to = validTo;
    }

}