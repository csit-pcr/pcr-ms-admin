//FIXME - We need to re-evaluate if we really require this.

package sg.gov.csit.pcrmsadmin.model;

import java.util.Set;

import sg.gov.csit.pcrmsadmin.config.Roles;
//This is to insert employee details for all roles

public class EmployeeDTO {
    public EmployeeDTO() {
    }

    private String name;

    private Long section;

    private String employeeID;

    private Long sectionAssigned;

    private Set<Roles> roles;

    private Long approverID;

    private Long adminID;

    private Long taskerID;

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the sectionAssigned
     */
    public Long getSectionAssigned() {
        return sectionAssigned;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the section
     */
    public Long getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(Long section) {
        this.section = section;
    }

    /**
     * @param employeeID the employeeNo to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @param sectionAssigned sectionAssigned to set
     */
    public void setSectionAssigned (Long sectionAssigned) {
        this.sectionAssigned = sectionAssigned;
    }

    /**
     * @return the roles
     */
    public Set<Roles> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    /**
     * @return the approverID
     */
    public Long getApproverID() {
        return approverID;
    }

    /**
     * @param approverID the approverID to set
     */
    public void setApproverID(Long approverID) {
        this.approverID = approverID;
    }

    /**
     * @return the adminID
     */
    public Long getAdminID() {
        return adminID;
    }

    /**
     * @param adminID the adminID to set
     */
    public void setAdminID(Long adminID) {
        this.adminID = adminID;
    }

    /**
     * @return the taskerID
     */
    public Long getTaskerID() {
        return taskerID;
    }

    /**
     * @param taskerID the taskerID to set
     */
    public void setTaskerID(Long taskerID) {
        this.taskerID = taskerID;
    }
}