package com.website.gizi.controller;

import com.website.gizi.model.Kegiatan;
import com.website.gizi.services.KegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value = "/kegiatan")
    public ModelAndView kegiatan(){
        return new ModelAndView("kegiatan/halamanKegiatan","kegiatanlist",kegiatanServices.getAllKegiatan());
    }
    @RequestMapping(value = "/tambahkegiatan")
    public String tambahkegiatan(){
        return "kegiatan/halamanKegiatanTambah";
    }

    @RequestMapping(value = "/tambahkegiatan",method = RequestMethod.POST)
    public String tambahKegiatanProses(@ModelAttribute("Kegiatan")Kegiatan kegiatan){
        kegiatanServices.SaveOrUpdateKegiatan(kegiatan);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/updatekegiatan",method = RequestMethod.GET)
    public ModelAndView updateKegiatan(@RequestParam("id")long id){
        return new ModelAndView("kegiatan/halamanKegiatanUpdate","kegiatanupdate",kegiatanServices.getKegiatanById(id));
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
