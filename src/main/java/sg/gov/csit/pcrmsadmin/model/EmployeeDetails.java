package sg.gov.csit.pcrmsadmin.model;

//Spring imports
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

//Java imports
import java.io.Serializable;

@MappedSuperclass
public class EmployeeDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;

    @NotBlank
    private String name;
        
    // Mapping to Section <Entity>-Parent

    @OneToOne
    @JoinColumn(name = "FK_section_ID")
    private Section section;

    public Long getEmployeeNo() {
        return this.employee_no;
    }
    
    public void setEmployeeNo(Long employeeNo) {
        this.employee_no = employeeNo;
    }

    public String getName() {
        return this.name;
    }

    public Section getSection() {
        return this.section;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setSection(Section section) {
        this.section = section;
    }
}

