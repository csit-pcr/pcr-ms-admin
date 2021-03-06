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
@Table(name="Admin")
@EntityListeners(AuditingEntityListener.class)
public class Admin extends EmployeeDetails implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long admin_id;

    //Start of Getters

    public Long getAdminID() {
        return this.admin_id;
    }

    //Start of Setters 

    public void setAdminID(Long ID) {
        this.admin_id= ID;
    }

}