package sg.gov.csit.pcrmsadmin.model;

import java.sql.Date;

//This is to insert employee details for all roles

public class DeptDTO {
    public DeptDTO() {
    }

    private Long cluster;

    private String sectionName;

    private Date validFrom;

    private Date validTo;

    private Long section;

    /**
     * @return the cluster
     */
    public Long getCluster() {
        return cluster;
    }

    /**
     * @return the sectionName
     */
    public String getSectionName() {
        return sectionName;
    }

    /**
     * @return the validFrom
     */
    public Date getValidFrom() {
        return validFrom;
    }

    /**
     * @return the validTo
     */
    public Date getValidTo() {
        return validTo;
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
     * @param cluster the clusterName to set
     */
    public void setCluster(Long cluster) {
        this.cluster = cluster;
    }

    /**
     * @param validFrom validFrom to set
     */
    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    /**
     * @param validTo validTo to set
     */
    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }
}