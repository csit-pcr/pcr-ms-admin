package sg.gov.csit.pcrmsadmin.model;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

public class RequestorID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "requestor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestor_id;
 
    @Column(name = "employee_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;
 
    public RequestorID() {
    }
 
    public RequestorID(Long requestorId, Long employeeId) {
        this.requestor_id= requestorId;
        this.employee_no = employeeId;
    }
 
    public Long getApproverId() {
        return requestor_id;
    }
 
    public Long getEmployeeNumber() {
        return employee_no;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((requestor_id == null) ? 0 : requestor_id.hashCode());
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
        RequestorID other = (RequestorID) o;
		if (requestor_id == null) {
			if (other.requestor_id != null)
				return false;
		} else if (!requestor_id.equals(other.requestor_id))
			return false;
		if (employee_no != other.employee_no)
			return false;
		return true;
    }
 
}