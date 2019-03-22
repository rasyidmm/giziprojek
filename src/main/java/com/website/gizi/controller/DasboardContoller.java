package com.website.gizi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DasboardContoller {
    @RequestMapping(value = "/halaman")
    public String Dasboardhalaman(){
        return "halamanDasboard";
    }
}
