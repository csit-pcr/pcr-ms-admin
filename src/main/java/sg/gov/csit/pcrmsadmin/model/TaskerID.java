package sg.gov.csit.pcrmsadmin.model;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

public class TaskerID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "tasker_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tasker_id;
 
    @Column(name = "employee_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;
 
    public TaskerID() {
    }
 
    public TaskerID(Long taskerId, Long employeeId) {
        this.tasker_id= taskerId;
        this.employee_no = employeeId;
    }
 
    public Long getTaskerId() {
        return tasker_id;
    }
 
    public Long getEmployeeNumber() {
        return employee_no;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((tasker_id == null) ? 0 : tasker_id.hashCode());
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
        TaskerID other = (TaskerID) o;
		if (tasker_id == null) {
			if (other.tasker_id != null)
				return false;
		} else if (!tasker_id.equals(other.tasker_id))
			return false;
		if (employee_no != other.employee_no)
			return false;
		return true;
    }
 
}