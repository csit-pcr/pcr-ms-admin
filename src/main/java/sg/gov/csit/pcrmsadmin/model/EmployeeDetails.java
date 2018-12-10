package sg.gov.csit.pcrmsadmin.model;

//Spring imports
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.ForeignKey;

//Java imports
import java.io.Serializable;

// @Entity
// @Table(name="EmployeeDetails")
// @EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;

    @NotBlank
    private String name;
        
    // Mapping to the Cluster, Section <Entity>-Parent

    @OneToOne
    @JoinColumn(name = "FK_section_ID")
    private Section section;

    @OneToOne
    @JoinColumn(name = "FK_cluster_ID")
    private Cluster cluster;

    // Start of Getters

    public Long getEmployeeNo() {
        return this.employee_no;
    }

    public String getName() {
        return this.name;
    }

    // public Cluster getCluster() {
    //     return this.cluster_id;
    // }

    // public Section getSection() {
    //     return this.section_id;
    // }
    // Start of Setters

    public void setEmployeeNo(Long employeeNo) {
        this.employee_no = employeeNo;
    }

    public void setName(String name) {
        this.name = name;
    }

}
