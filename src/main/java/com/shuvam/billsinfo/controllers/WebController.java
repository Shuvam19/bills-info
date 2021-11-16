package com.shuvam.billsinfo.controllers;

import com.shuvam.billsinfo.Model.BillInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

    @RequestMapping("/")
    public String addBill(Model model){
        model.addAttribute("bill",new BillInfo());
        return "add-bill";
    }

}
