package com.GiveaLot.givealot.Report.dataclass;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Reports {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "report_id", nullable = false, unique = true)
    public Long reportId;

    private Long orgId;
    private Long userId;
    private String reportType;
    private String date;
    private String description;
    private boolean appealed;

    public Reports() {

    }

    public boolean isAppealed() {
        return appealed;
    }

    public void setAppealed(boolean appealed) {
        this.appealed = appealed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
