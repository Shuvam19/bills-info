package com.shuvam.billsinfo.controllers;

import com.shuvam.billsinfo.Model.BillInfo;
import com.shuvam.billsinfo.repository.BillInfoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class RestApiController {

    public BillInfoRepository billInfoRepository;

    public RestApiController(BillInfoRepository billInfoRepository) {
        this.billInfoRepository = billInfoRepository;
    }

    @GetMapping("/bills")
    public List<BillInfo> getAllBillInfo() {
        return billInfoRepository.findAll();
    }

    @GetMapping("/bill/{id}")
    public BillInfo getBillById(@PathVariable("id") String id) {
        Optional<BillInfo> billInfo = billInfoRepository.findById(Long.parseLong(id));
        return billInfo.orElse(null);
    }

    @GetMapping("/bill/due/{date}")
    public List<BillInfo> getBillById(@PathVariable("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return billInfoRepository.findBillInfoByBillDueDate(date);
    }

    @PostMapping("/add-bill")
    public BillInfo addBill(@ModelAttribute BillInfo billInfo) {
        return billInfoRepository.save(billInfo);
    }
}
