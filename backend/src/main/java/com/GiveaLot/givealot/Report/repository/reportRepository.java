package com.GiveaLot.givealot.Report.repository;

import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Report.dataclass.Reports;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface reportRepository extends JpaRepository<Reports, Long>
{
    @Query("select re from Reports re where re.orgId = ?1")
    List<Reports> getAllReports(Long id);

    @Query("select re from Reports re where re.appealed = true")
    List<Reports> getAppealedReports();

    @Query("select re from Reports re where re.reportId = ?1")
    Reports getReportById(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE Reports re SET re.appealed = true WHERE re.reportId = ?1")
    Integer appealReport(Long reportId);
}
