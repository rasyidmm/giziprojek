package com.website.gizi.controller;

import com.website.gizi.model.KegiatanRekapitulasi;
import com.website.gizi.model.Penilaian;
import com.website.gizi.model.TargetPenilaian;
import com.website.gizi.services.KegiatanServices;
import com.website.gizi.services.RekapitulasiServices;
import com.website.gizi.services.TargetPenilaianServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PenilaianController {
    @Autowired
    KegiatanServices kegiatanServices;
    @Autowired
    RekapitulasiServices rekapitulasiServices;
    @Autowired
    TargetPenilaianServices targetPenilaianServices;
    @RequestMapping(value = "/rekapitulasikegiatanterpilih")
    public ModelAndView rekapitulasiKegiatanTerpilih(@Param("idr")long idr){
        ModelAndView mav = new ModelAndView();
        mav.addObject("kegiatanNONnilai",kegiatanServices.findKegiatanNONByTargetPenilaian(idr));
        mav.addObject("kegiatannilai",kegiatanServices.findKegiatanByTargetPenilaian(idr));
        mav.setViewName("rekapitulasi/halamanPenilaianKegiatanTerpilih");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasinilaiset")
    public ModelAndView rekapitulasiNilaiSet(@Param("id")long id, @Param("idr")long idr){
        ModelAndView mav = new ModelAndView();
        mav.addObject("kegiatanpilih",kegiatanServices.getKegiatanById(id));
        mav.addObject("rekapitulasi",rekapitulasiServices.getRekapitulasiById(idr));
        mav.setViewName("rekapitulasi/");
        return mav;
    }
    @RequestMapping(value = "/rekapitulasinilaisetproses")
    public String rekapitulasiNilaiSetproses(@Param("id")long id,@Param("idr")long idr){
        TargetPenilaian tr =  new TargetPenilaian();
        tr.setRekapitulasi(rekapitulasiServices.getRekapitulasiById(idr));
        tr.setKegiatan(kegiatanServices.getKegiatanById(id));
        targetPenilaianServices.SaveOrUpdateTargetPenilaian(tr);
        return "redirect:rekapitulasikegiatanterpilih?idr="+idr;
    }
}
