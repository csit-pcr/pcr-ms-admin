//FIXME - consider rename to Employee and convert this to an entity

package sg.gov.csit.pcrmsadmin.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;

//Spring imports
// import org.springframework.data.jpa.domain.support.AuditingEntityListener;

//Javax imports
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import sg.gov.csit.pcrmsadmin.config.Roles;

@Entity
@Table(name = "employeeDetails")
@Inheritance(strategy = InheritanceType.JOINED)
// @OnDelete(action = OnDeleteAction.NO_ACTION)
public class EmployeeDetails {
    // private static final long serialVersionUID = 1L;

    @Id
    private String employee_id;

    @NotBlank
    @Column(name = "name")
    private String name;

    // Mapping to Section <Entity>-Parent

    @OneToOne
    @JoinColumn(name = "FK_section_ID")
    private Section section;

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "roles", joinColumns = @JoinColumn(name = "employee_id"))
    @Column(name = "rolesOfPCR", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles = new HashSet<>();

    public Set<Roles> getRoles() {
        return this.roles;
    }

    public String getEmployeeID() {
        return this.employee_id;
    }

    public String getName() {
        return this.name;
    }

    public Section getSection() {
        return this.section;
    }

    public void setEmployeeID(String employeeID) {
        this.employee_id = employeeID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}
