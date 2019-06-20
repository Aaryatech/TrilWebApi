package com.ats.tril.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ats.tril.model.CurrentIssueDetail;

public interface CurrentIssueDetailRepository extends JpaRepository<CurrentIssueDetail, Integer>{

	@Query(value=("Select\n" + 
			"            item_issue_detail.item_id,SUM(item_issue_detail.item_issue_qty) as issue_qty,SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) as issue_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) as issue_qty_value \n" + 
			"        FROM\n" + 
			"            item_issue_header,\n" + 
			"            item_issue_detail,\n" + 
			"            t_mrn_detail,\n" + 
			"            po_detail  \n" + 
			"        WHERE\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate  \n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id  \n" + 
			"            and item_issue_header.delete_status=1 \n" + 
			"            and item_issue_detail.del_status=1 \n" + 
			"            AND item_issue_detail.status = 2\n" + 
			"             and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id \n" + 
			"    group by item_issue_detail.item_id"),nativeQuery=true)
	List<CurrentIssueDetail> issueDetail(@Param("fromDate") String fromDate,@Param("toDate") String toDate);

	@Query(value=("Select\n" + 
			"            item_issue_detail.item_id,SUM(item_issue_detail.item_issue_qty) as issue_qty,SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) as issue_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) as issue_qty_value \n" + 
			"        FROM\n" + 
			"            item_issue_header,\n" + 
			"            item_issue_detail,\n" + 
			"            t_mrn_detail,\n" + 
			"            po_detail,m_item  \n" + 
			"        WHERE\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate  \n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id  \n" + 
			"            and item_issue_header.delete_status=1 \n" + 
			"            and item_issue_detail.del_status=1 \n" + 
			"            AND item_issue_detail.status = 2\n" + 
			"             and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.item_id=item_issue_detail.item_id and   m_item.cat_id=:catId \n" + 
			"    group by item_issue_detail.item_id"),nativeQuery=true)
	List<CurrentIssueDetail> issueDetailByCatId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("catId") int catId);

	@Query(value=("Select\n" + 
			"            item_issue_detail.item_id,SUM(item_issue_detail.item_issue_qty) as issue_qty,SUM(item_issue_detail.item_issue_qty*po_detail.item_rate) as issue_landing_value,SUM((po_detail.landing_cost/po_detail.item_qty)*item_issue_detail.item_issue_qty) as issue_qty_value \n" + 
			"        FROM\n" + 
			"            item_issue_header,\n" + 
			"            item_issue_detail,\n" + 
			"            t_mrn_detail,\n" + 
			"            po_detail,m_item  \n" + 
			"        WHERE\n" + 
			"            item_issue_header.issue_date between :fromDate and :toDate  \n" + 
			"            AND item_issue_header.issue_id=item_issue_detail.issue_id  \n" + 
			"            and item_issue_header.delete_status=1 \n" + 
			"            and item_issue_detail.del_status=1 \n" + 
			"            AND item_issue_detail.status = 2\n" + 
			"            and item_issue_detail.mrn_detail_id=t_mrn_detail.mrn_detail_id and item_issue_header.item_category=:typeId  \n" + 
			"            and po_detail.po_detail_id=t_mrn_detail.po_detail_id and m_item.item_id=item_issue_detail.item_id and   m_item.cat_id=:catId \n" + 
			"    group by item_issue_detail.item_id"),nativeQuery=true)
	List<CurrentIssueDetail> issueDetailByCatIdAndTypeId(@Param("fromDate")String fromDate,@Param("toDate") String toDate,@Param("catId") int catId,@Param("typeId") int typeId);

}
