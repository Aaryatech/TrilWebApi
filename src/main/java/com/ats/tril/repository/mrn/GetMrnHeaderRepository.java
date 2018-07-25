package com.ats.tril.repository.mrn;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.tril.model.mrn.GetMrnHeader;

@Repository
public interface GetMrnHeaderRepository extends JpaRepository<GetMrnHeader, Integer> {

	@Query(value = "select h.mrn_id,h.mrn_no,h.mrn_type,h.mrn_date,h.vendor_id,v.vendor_name,h.gate_entry_no,h.gate_entry_date,h.doc_no,h.doc_date,h.bill_no,h.bill_date,h.transport,h.lr_no,h.lr_date,h.remark1,h.remark2,h.user_id,h.mrn_status,h.del_status from t_mrn_header h,m_vendor v where v.vendor_id=h.vendor_id and h.mrn_status In(:status)  and h.del_status=1", nativeQuery = true)
	List<GetMrnHeader> getMrnHeaderListByStatus(@Param("status") List<Integer> status);

	@Query(value = "select h.mrn_id,h.mrn_no,h.mrn_type,h.mrn_date,h.vendor_id,v.vendor_name,h.gate_entry_no,h.gate_entry_date,h.doc_no,h.doc_date,h.bill_no,h.bill_date,h.transport,h.lr_no,h.lr_date,h.remark1,h.remark2,h.user_id,h.mrn_status,h.del_status from t_mrn_header h,m_vendor v where v.vendor_id=h.vendor_id and h.vendor_id IN(:venId) and h.del_status=1", nativeQuery = true)
	List<GetMrnHeader> getMrnHeaderListByVenId(@Param("venId") List<Integer> venId);

	@Query(value = "select h.mrn_id,h.mrn_no,h.mrn_type,h.mrn_date,h.vendor_id,v.vendor_name,h.gate_entry_no,h.gate_entry_date,h.doc_no,h.doc_date,h.bill_no,h.bill_date,h.transport,h.lr_no,h.lr_date,h.remark1,h.remark2,h.user_id,h.mrn_status,h.del_status from t_mrn_header h,m_vendor v where v.vendor_id=h.vendor_id and h.mrn_status In(:status) and h.vendor_id IN(:venId) and h.del_status=1", nativeQuery = true)
	List<GetMrnHeader> getMrnHeaderListByVenIdAndStatus(@Param("venId") List<Integer> venId,
			@Param("status") List<Integer> status);

	@Query(value = "select h.mrn_id,h.mrn_no,h.mrn_type,h.mrn_date,h.vendor_id,v.vendor_name,h.gate_entry_no,h.gate_entry_date,h.doc_no,h.doc_date,h.bill_no,h.bill_date,h.transport,h.lr_no,h.lr_date,h.remark1,h.remark2,h.user_id,h.mrn_status,h.del_status from t_mrn_header h,m_vendor v where v.vendor_id=h.vendor_id  and h.del_status=1", nativeQuery = true)
	List<GetMrnHeader> getAllMrnHeaderList();

	@Query(value = "SELECT h.mrn_id,h.mrn_no,h.mrn_type,h.mrn_date,h.vendor_id,v.vendor_name,h.gate_entry_no,h.gate_entry_date,h.doc_no,"
			+ "h.doc_date,h.bill_no,h.bill_date,h.transport,h.lr_no,h.lr_date,h.remark1,h.remark2,h.user_id,h.mrn_status,h.del_status "
			+ "FROM t_mrn_header h,m_vendor v WHERE v.vendor_id=h.vendor_id  AND h.del_status=1 AND h.mrn_date BETWEEN :fromDate AND :toDate"
			+ " ", nativeQuery = true)
	List<GetMrnHeader> getMrnHeaderByDate(@Param("fromDate") String fromDate, @Param("toDate") String toDate);

	@Query(value = "SELECT m.*, v.vendor_name FROM t_mrn_header m,m_vendor v WHERE m.vendor_id=v.vendor_id AND  m.mrn_id IN(:status)  AND m.del_status=1", nativeQuery = true)
	List<GetMrnHeader> getMrnHeaderByList(@Param("status") List<Integer> status);

}
