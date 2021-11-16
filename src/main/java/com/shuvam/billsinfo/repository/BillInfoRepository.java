package com.shuvam.billsinfo.repository;

import com.shuvam.billsinfo.Model.BillInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillInfoRepository extends JpaRepository<BillInfo,Long> {
    List<BillInfo> findBillInfoByBillDueDate(LocalDate date);
}
