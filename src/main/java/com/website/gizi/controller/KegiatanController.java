package com.website.gizi.controller;

import com.website.gizi.model.Kegiatan;
import com.website.gizi.services.AktorServices;
import com.website.gizi.services.KegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KegiatanController {

    @Autowired
    KegiatanServices kegiatanServices;
    @Autowired
    AktorServices aktorServices;
    @RequestMapping(value = "/kegiatan")
    public ModelAndView kegiatan(){
        return new ModelAndView("kegiatan/halamanKegiatan","kegiatanlist",kegiatanServices.getAllKegiatan());
    }
    @RequestMapping(value = "/tambahkegiatan")
    public ModelAndView tambahkegiatan(){

        return new ModelAndView("kegiatan/halamanKegiatanTambah","anggotalist",aktorServices.getAllAktor());
    }

    @RequestMapping(value = "/tambahkegiatan",method = RequestMethod.POST)
    public String tambahKegiatanProses(@ModelAttribute("Kegiatan")Kegiatan kegiatan, @Param("Anggotaid")long Anggotaid){
        kegiatan.setAktor(aktorServices.getAktorById(Anggotaid));
        kegiatanServices.SaveOrUpdateKegiatan(kegiatan);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/updatekegiatan",method = RequestMethod.GET)
    public ModelAndView updateKegiatan(@RequestParam("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("kegiatanupdate",kegiatanServices.getKegiatanById(id));
        mav.addObject("aktorlist",aktorServices.getAllAktor());
        mav.setViewName("kegiatan/halamanKegiatanUpdate");
        return mav;
    }
    @RequestMapping(value = "/updatekegiatan",method = RequestMethod.POST)
    public String updateKegiatanProses(@ModelAttribute("Kegiatan")Kegiatan kegiatan){
        kegiatanServices.SaveOrUpdateKegiatan(kegiatan);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/kegiatandetail",method = RequestMethod.GET)
    public ModelAndView kegiatandetail(@RequestParam("id")long id){
        return new ModelAndView("kegiatan/halamanKegiatanDetail","kegiatandetail",kegiatanServices.getKegiatanById(id));
    }
    @RequestMapping(value = "/kegiatanhapus")
    public String kegeiatanHapus(@RequestParam("id")long id){
        kegiatanServices.deleteKegiatanById(id);
        return "redirect:kegiatan";
    }
}
