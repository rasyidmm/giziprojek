package com.website.gizi.controller;

import com.website.gizi.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
@Controller
public class RekapitulasiUserController {
    @Autowired
    AktorServices aktorServices;
    @Autowired
    WaktuKegiatanServices waktuKegiatanServices;
    @Autowired
    RekapitulasiServices rekapitulasiServices;
    @Autowired
    KegiatanServices kegiatanServices;
    @Autowired
    KegiatanRekapitulasiService kegiatanRekapitulasiService;
    @Autowired
    TargetPenilaianServices targetPenilaianServices;
    @RequestMapping(value = "/asdasd")
    public ModelAndView rekapitulasiFromAktor(@Param("id")long id) throws ParseException {
        String Date = date("MM-yyyy");
        ModelAndView mav =  new ModelAndView();
        mav.addObject("aktorpilih",aktorServices.getAktorById(id));
        mav.addObject("rekapitulasiThisMonth",rekapitulasiServices.findRekapitulasiByAktorAndWaktuKegiatanThisMonth(Date,id));
        mav.addObject("rekapitulasiLastMonth",rekapitulasiServices.findRekapitulasiByAktorAndWaktuKegiatanLastMonth(Date,id));
        mav.setViewName("user/rekapitulasi/halamanRekapitulasi");
        System.out.printf(Date);
        return mav;
    }
}
