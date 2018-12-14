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

    @NotBlank
    private String name;
        
    // Mapping to Section <Entity>-Parent

    @OneToOne
    @JoinColumn(name = "FK_section_ID")
    private Section section;

    public String getName() {
        return this.name;
    }

    public Section getSection() {
        return this.section;
    }
    
    public void setName(String name) {
        this.name = name;
    }

}
