package com.website.gizi.controller;

import com.website.gizi.model.Kegiatan;
import com.website.gizi.services.AktorServices;
import com.website.gizi.services.KegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class KegiatanController {

    @Autowired
    KegiatanServices kegiatanServices;
    @Autowired
    AktorServices aktorServices;

    @RequestMapping(value = "/kegiatan")
    public ModelAndView kegiatan() {
        return new ModelAndView("kegiatan/halamanKegiatan", "kegiatanlist", kegiatanServices.findKegiatanByStatusActive());
    }

    @RequestMapping(value = "/tambahkegiatan")
    public ModelAndView tambahkegiatan() {

        return new ModelAndView("kegiatan/halamanKegiatanTambah", "anggotalist", aktorServices.getAllAktor());
    }

    @RequestMapping(value = "/tambahkegiatan", method = RequestMethod.POST)
    public String tambahKegiatanProses(@ModelAttribute("Kegiatan") Kegiatan kegiatan, @Param("Anggotaid") long Anggotaid) {
        kegiatan.setAktor(aktorServices.getAktorById(Anggotaid));
        kegiatan.setCreateDate(new Date());
        kegiatan.setStatus("Active");
        kegiatanServices.SaveOrUpdateKegiatan(kegiatan);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/updatekegiatan", method = RequestMethod.GET)
    public ModelAndView updateKegiatan(@RequestParam("id") long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("kegiatanupdate", kegiatanServices.getKegiatanById(id));
        mav.addObject("aktorlist", aktorServices.getAllAktor());
        mav.setViewName("kegiatan/halamanKegiatanUpdate");
        return mav;
    }

    @RequestMapping(value = "/updatekegiatan", method = RequestMethod.POST)
    public String updateKegiatanProses(@ModelAttribute("Kegiatan") Kegiatan k,@RequestParam("id")long id) {
        Kegiatan kegiatan = kegiatanServices.getKegiatanById(id);
        k.setId(kegiatan.getId());
        k.setCreateBy(kegiatan.getCreateBy());
        k.setCreateDate(kegiatan.getCreateDate());
        k.setStatus(kegiatan.getStatus());
        k.setKeterangan(kegiatan.getKeterangan());
        k.setUpdateBy(kegiatan.getUpdateBy());
        k.setUpdateDate(new Date());
        kegiatanServices.SaveOrUpdateKegiatan(k);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/kegiatandetail", method = RequestMethod.GET)
    public ModelAndView kegiatandetail(@RequestParam("id") long id) {
        return new ModelAndView("kegiatan/halamanKegiatanDetail", "kegiatandetail", kegiatanServices.getKegiatanById(id));
    }

    @RequestMapping(value = "/kegiatanhapus")
    public String kegeiatanHapus(@RequestParam("id") long id) {
        kegiatanServices.deleteKegiatanById(id);
        return "redirect:kegiatan";
    }

    @RequestMapping(value = "/kegiatanhapusStatus")
    public String kegiatanHapusStatus(@RequestParam("id") long id, @ModelAttribute("Kegiatan") Kegiatan K) {
        Kegiatan kegiatan = kegiatanServices.getKegiatanById(id);
        K.setId(kegiatan.getId());
        K.setCreateBy(kegiatan.getCreateBy());
        K.setCreateDate(kegiatan.getCreateDate());
        K.setStatus("Deleted");
        K.setKeterangan(kegiatan.getKeterangan());
        K.setUpdateBy(kegiatan.getUpdateBy());
        K.setUpdateDate(new Date());
        K.setNamaKegiatan(kegiatan.getNamaKegiatan());
        K.setTanggalKegiatan(kegiatan.getTanggalKegiatan());
        K.setAktor(kegiatan.getAktor());
        kegiatanServices.SaveOrUpdateKegiatan(K);
        return "redirect:kegiatan";
    }
}
