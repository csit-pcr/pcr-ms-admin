package sg.gov.csit.pcrmsadmin.model;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

public class AdminID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "admin_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long admin_id;
 
    @Column(name = "employee_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;
 
    public AdminID() {
    }
 
    public AdminID(Long adminId, Long employeeId) {
        this.admin_id= adminId;
        this.employee_no = employeeId;
    }
 
    public Long getAdminId() {
        return admin_id;
    }
 
    public Long getEmployeeNumber() {
        return employee_no;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((admin_id == null) ? 0 : admin_id.hashCode());
        result = prime * result + ((employee_no == null) ? 0 : employee_no.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) 
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass()) 
            return false;
        AdminID other = (AdminID) o;
		if (admin_id == null) {
			if (other.admin_id != null)
				return false;
		} else if (!admin_id.equals(other.admin_id))
			return false;
		if (employee_no != other.employee_no)
			return false;
		return true;
    }
 
}