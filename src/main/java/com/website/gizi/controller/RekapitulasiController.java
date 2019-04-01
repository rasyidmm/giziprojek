package com.website.gizi.controller;

import com.website.gizi.model.WaktuKegiatan;
import com.website.gizi.services.WaktuKegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RekapitulasiController {
    @Autowired
    WaktuKegiatanServices waktuKegiatanServices;

    @RequestMapping(value = "/rekapitulasiwaktu")
    public String rekapitulasiWaktu(){
        return "rekapitulasi/halamanRekapitulasiwaktu";
    }
    @RequestMapping(value = "/rekapitulasiwaktu",method = RequestMethod.POST)
    public ModelAndView rekapitulasiWaktuproses(@ModelAttribute("WaktuKegiatan")WaktuKegiatan waktuKegiatan, @RequestParam("tanggalKegiatan")String tanggalKegiatan){
        waktuKegiatan.setWaktuRekapitulasi(tanggalKegiatan);
        waktuKegiatanServices.SaveOrUpdateWaktuKegiatan(waktuKegiatan);
        ModelAndView mav= new ModelAndView();
        mav.addObject("");
        mav.addObject("");
        mav.setViewName("");
        return mav;
    }

}
