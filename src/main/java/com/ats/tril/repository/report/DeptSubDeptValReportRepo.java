package com.ats.tril.repository.report;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.report.DeptSubDeptValReport;

public interface DeptSubDeptValReportRepo  extends JpaRepository<DeptSubDeptValReport, Integer>{
	
	
	@Query(value=("SELECT" + 
			"        m_sub_dept.sub_dept_id as sub_dept_id," + 
			"        concat(m_sub_dept.sub_dept_code," + 
			"        ' '," + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code," + 
			
			"        m_dept.dept_id as dept_id," + 
			"        concat(m_dept.dept_code," + 
			"        ' '," + 
			"        m_dept.dept_desc) as dept_code," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty) " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail,m_item " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id " + 
			"            and item_issue_header.delete_status=1 " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail,m_item," + 
			"            po_detail " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id " + 
			"            and item_issue_header.delete_status=1 " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_landing_value," + 
			"        coalesce((Select" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail,m_item " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id " + 
			"            and item_issue_header.delete_status=1 " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty_value " + 
			"    FROM" + 
			"        m_sub_dept,m_dept " + 
			"    where" + 
			"        m_sub_dept.is_used=1" + 
			"        and m_sub_dept.dept_id=m_dept.dept_id"),nativeQuery=true)
	List<DeptSubDeptValReport> issueSubDeptWiseReportWithTypeIdAndIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("catIds") List<Integer> catIds);

	@Query(value=("SELECT" + 
			"        m_sub_dept.sub_dept_id as sub_dept_id," + 
			"        concat(m_sub_dept.sub_dept_code," + 
			"        ' '," + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code," + 
			
			"        m_dept.dept_id as dept_id," + 
			"        concat(m_dept.dept_code," + 
			"        ' '," + 
			"        m_dept.dept_desc) as dept_code," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_header," + 
			"            indent,m_item          " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id               " + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail," + 
			"            po_header," + 
			"            indent,m_item                                " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_landing_value," + 
			"        coalesce((Select" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail," + 
			"            po_header," + 
			"            indent,m_item                              " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty_value                    " + 
			"    FROM" + 
			"        m_sub_dept,m_dept " + 
			"    where" + 
			"        m_sub_dept.is_used=1" + 
			"        and m_sub_dept.dept_id=:deptId AND m_dept.dept_id=m_sub_dept.dept_id "),nativeQuery=true)
	List<DeptSubDeptValReport> issueSubDeptWiseReportWithTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("isDev")int isDev,@Param("deptId") int deptId,@Param("catIds") List<Integer> catIds);

	@Query(value=("SELECT" + 
			"        m_sub_dept.sub_dept_id as sub_dept_id," + 
			"        concat(m_sub_dept.sub_dept_code," + 
			"        ' '," + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code," + 
			
			"        m_dept.dept_id as dept_id," + 
			"        concat(m_dept.dept_code," + 
			"        ' '," + 
			"        m_dept.dept_desc) as dept_code," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail,m_item                       " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail,m_item                                " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_landing_value," + 
			"        coalesce((Select" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail,m_item                               " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and item_issue_header.item_category=:typeId AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty_value   " + 
			"    FROM" + 
			"        m_sub_dept,m_dept " + 
			"    where" + 
			"        m_sub_dept.is_used=1" + 
			"        and m_sub_dept.dept_id=:deptId AND m_dept.dept_id=m_sub_dept.dept_id "),nativeQuery=true)
	List<DeptSubDeptValReport> issueSubDeptWiseReportWithIsDev(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("deptId") int deptId,@Param("catIds") List<Integer> catIds);

	@Query(value=("SELECT" + 
			"        m_sub_dept.sub_dept_id as sub_dept_id," + 
			"        concat(m_sub_dept.sub_dept_code," + 
			"        ' '," + 
			"        m_sub_dept.sub_dept_desc) as sub_dept_code," + 
			
			"        m_dept.dept_id as dept_id," + 
			"        concat(m_dept.dept_code," + 
			"        ' '," + 
			"        m_dept.dept_desc) as dept_code," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_header," + 
			"            indent,m_item          " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                          " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                              " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1 " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and item_issue_header.item_category=:typeId " + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty," + 
			"        coalesce((Select" + 
			"            SUM(item_issue_detail.item_issue_qty*po_detail.item_rate)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail," + 
			"            po_header," + 
			"            indent,m_item                               " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id              " + 
			"            and item_issue_header.item_category=:typeId" + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_landing_value," + 
			"        coalesce((Select" + 
			"            SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty)                               " + 
			"        FROM" + 
			"            item_issue_header," + 
			"            item_issue_detail," + 
			"            t_mrn_detail," + 
			"            po_detail," + 
			"            po_header," + 
			"            indent,m_item                              " + 
			"        WHERE" + 
			"            item_issue_header.issue_date between :fromDate and :toDate                                           " + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id                               " + 
			"            and item_issue_header.delete_status=1                                           " + 
			"            and item_issue_detail.del_status=1                                           " + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id                                           " + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id " + 
			"            and item_issue_header.sub_dept_id=m_sub_dept.sub_dept_id             " + 
			"            and item_issue_header.item_category=:typeId " + 
			"            and t_mrn_detail.mrn_detail_id=item_issue_detail.mrn_detail_id              " + 
			"            and t_mrn_detail.po_id=po_header.po_id " + 
			"            and po_header.ind_id=indent.ind_m_id " + 
			"            and indent.ind_isdev=:isDev AND item_issue_detail.status = 2 and m_item.item_id=item_issue_detail.item_id and m_item.cat_id in (:catIds))," + 
			"        0) AS issue_qty_value  " + 
			"    FROM" + 
			"        m_sub_dept,m_dept " + 
			"    where" + 
			"        m_sub_dept.is_used=1" + 
			"        and m_sub_dept.dept_id=:deptId AND m_dept.dept_id=m_sub_dept.dept_id "),nativeQuery=true)
	List<DeptSubDeptValReport> issueSubDeptWiseReport(@Param("fromDate")String fromDate,@Param("toDate") String toDate,
			@Param("typeId")int typeId, @Param("isDev")int isDev, @Param("deptId") int deptId,@Param("catIds") List<Integer> catIds);



}
