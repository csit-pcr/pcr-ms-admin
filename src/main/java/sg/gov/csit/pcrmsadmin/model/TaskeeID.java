package sg.gov.csit.pcrmsadmin.model;

//Javax imports
import javax.persistence.*;

//Java imports
import java.io.Serializable;
// import java.util.Set;

public class TaskeeID implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "taskee_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskee_id;
 
    @Column(name = "employee_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employee_no;
 
    public TaskeeID() {
    }
 
    public TaskeeID(Long taskeeId, Long employeeId) {
        this.taskee_id= taskeeId;
        this.employee_no = employeeId;
    }
 
    public Long getTaskeeId() {
        return taskee_id;
    }
 
    public Long getEmployeeNumber() {
        return employee_no;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((taskee_id == null) ? 0 : taskee_id.hashCode());
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
        TaskeeID other = (TaskeeID) o;
		if (taskee_id == null) {
			if (other.taskee_id != null)
				return false;
		} else if (!taskee_id.equals(other.taskee_id))
			return false;
		if (employee_no != other.employee_no)
			return false;
		return true;
    }
 
}