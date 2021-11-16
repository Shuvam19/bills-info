package com.shuvam.billsinfo.bootstrap;

import com.shuvam.billsinfo.Model.BillInfo;
import com.shuvam.billsinfo.repository.BillInfoRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Controller
public class BootstrapData implements ApplicationListener<ContextRefreshedEvent> {

    public BillInfoRepository billInfoRepository;

    public BootstrapData(BillInfoRepository billInfoRepository) {
        this.billInfoRepository = billInfoRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        billInfoRepository.saveAll(getAllBills());
    }

    private Set<BillInfo> getAllBills() {
        Set<BillInfo> billInfos = new HashSet<>();
        billInfos.add(new BillInfo("Shuvam Kumar",new Date(System.currentTimeMillis()).toLocalDate(),20L,12.2f,32.2f, LocalDate.of(2020,12,21)));
        billInfos.add(new BillInfo("Shweta Verma",new Date(System.currentTimeMillis()).toLocalDate(),120L,30f,150f, LocalDate.of(2020,4,28)));
        billInfos.add(new BillInfo("Savita Patel",new Date(System.currentTimeMillis()).toLocalDate(),2000L,200f,2200f, LocalDate.of(2020,6,15)));
        billInfos.add(new BillInfo("Ramesh Kumar",new Date(System.currentTimeMillis()).toLocalDate(),620L,60f,680f, LocalDate.of(2020,7,12)));
        billInfos.add(new BillInfo("Rajesh Khatri",new Date(System.currentTimeMillis()).toLocalDate(),3420L,700f,4120f, LocalDate.of(2020,2,16)));
        billInfos.add(new BillInfo("Ansh Patel",new Date(System.currentTimeMillis()).toLocalDate(),2870L,500f,3370f, LocalDate.of(2020,8,19)));
        billInfos.add(new BillInfo("Nikhil Yadav",new Date(System.currentTimeMillis()).toLocalDate(),1920L,200f,2120f, LocalDate.of(2020,3,15)));
        billInfos.add(new BillInfo("Nishant patel",new Date(System.currentTimeMillis()).toLocalDate(),3220L,320f,3540f, LocalDate.of(2020,1,1)));
        return billInfos;
    }
}
