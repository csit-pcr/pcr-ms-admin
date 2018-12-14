package sg.gov.csit.pcrmsadmin.model;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

public class ApproverID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "approver_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approver_id;
 
    @Column(name = "employee_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;
 
    public ApproverID() {
    }
 
    public ApproverID(Long approverId, Long employeeId) {
        this.approver_id= approverId;
        this.employee_no = employeeId;
    }
 
    public Long getApproverId() {
        return approver_id;
    }
 
    public Long getEmployeeNumber() {
        return employee_no;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((approver_id == null) ? 0 : approver_id.hashCode());
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
        ApproverID other = (ApproverID) o;
		if (approver_id == null) {
			if (other.approver_id != null)
				return false;
		} else if (!approver_id.equals(other.approver_id))
			return false;
		if (employee_no != other.employee_no)
			return false;
		return true;
    }
 
}