package sg.gov.csit.pcrmsadmin.model;

//This is to insert employee details for all roles

public class EmployeeDTO {
    public EmployeeDTO() {
    }

    private String name;

    private Long section;

    private Long employeeNo;

    private Long sectionAssigned;

    /**
     * @return the employeeNo
     */
    public Long getEmployeeNo() {
        return employeeNo;
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
     * @param employeeNo the employeeNo to set
     */
    public void setEmployeeNo(Long employeeNo) {
        this.employeeNo = employeeNo;
    }

    /**
     * @param sectionAssigned sectionAssigned to set
     */
    public void setSectionAssigned (Long sectionAssigned) {
        this.sectionAssigned = sectionAssigned;
    }
}