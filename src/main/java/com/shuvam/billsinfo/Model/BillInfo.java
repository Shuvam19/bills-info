package com.shuvam.billsinfo.Model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BillInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long BillNumber;
    private String BilledTo;
    private Long BillPrice;
    private Float BillTax;
    private Float TotalPrice;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate BillDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate billDueDate;

    public BillInfo(String billedTo, LocalDate billDate, Long billPrice, Float billTax, Float totalPrice, LocalDate billDueDate) {
        BilledTo = billedTo;
        BillDate = billDate;
        BillPrice = billPrice;
        BillTax = billTax;
        TotalPrice = totalPrice;
        this.billDueDate = billDueDate;
    }
}
