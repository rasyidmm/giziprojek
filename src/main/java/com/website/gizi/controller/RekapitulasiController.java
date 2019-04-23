package com.website.gizi.controller;

import com.website.gizi.model.*;
import com.website.gizi.services.*;
import jdk.nashorn.internal.objects.ArrayBufferView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class RekapitulasiController {
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

    @RequestMapping(value = "/rekapitulasi")
    public ModelAndView rekapitulasi(){
        return new ModelAndView("rekapitulasi/halamanRekapitulasi","rekapitulasilist",rekapitulasiServices.getAllRekapitulasi());
    }

    @RequestMapping(value = "/rekapitulasimemberset")
    public ModelAndView rekapitulasiCreate(@Param("id")long id){
        ModelAndView mav = new ModelAndView();
        mav.addObject("wakturekapitulasi",waktuKegiatanServices.getWaktuKegiatanById(id));
        mav.addObject("listaktorSet",aktorServices.findAktorByWaktu(id));
        mav.setViewName("rekapitulasi/halamanRekapitulasiMember");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasimembersett")
    public String RekapitulasiMemberSet(@Param("id")long id,@Param("ids")long ids){
        Aktor a = aktorServices.getAktorById(id);
        WaktuKegiatan wk = waktuKegiatanServices.getWaktuKegiatanById(ids);
        Rekapitulasi rekapitulasi =  new Rekapitulasi();
        rekapitulasi.setNamaRekapitulasi(a.getNamaAkhir()+" "+a.getNamaAkhir()+" "+(wk.getWaktuRekapitulasi()));
        rekapitulasi.setAktor(a);
        rekapitulasi.setWaktuKegiatan(wk);
        rekapitulasiServices.SaveOrUpdateRekapitulasi(rekapitulasi);
        Rekapitulasi grer = rekapitulasiServices.findRekapitulasiByAktorAndWaktuKegiatan(id,ids);
        long idr = grer.getId();
        return "redirect:rekapitulasikegiatanset?idr=&?ida="+idr+id;
    }

    @RequestMapping(value = "/rekapitulasikegiatanset")
    public ModelAndView rekapitulasiKegiatanSet(@Param("idr")long idr,@Param("ida")long ida){
        ModelAndView mav = new ModelAndView();
        mav.addObject("rekapitulasipilih",rekapitulasiServices.getRekapitulasiById(idr));
        mav.addObject("kegiatanterpilihlist",kegiatanServices.findKegiatanByRekapitulasiID(idr));
        mav.addObject("aktorpilih",aktorServices.getAktorById(ida));
        mav.setViewName("rekapitulasi/halamanRekapitulasiKegiatan");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasimemilih")
    public ModelAndView rekapitulasiMemilihKegiatan(@Param("idr")long idr,@Param("ida")long ida){
        Rekapitulasi r = rekapitulasiServices.getRekapitulasiById(idr);
        ModelAndView mav = new ModelAndView();
        mav.addObject("rekapitulasipilih",rekapitulasiServices.getRekapitulasiById(idr));
        mav.addObject("kegiatannonmilih",kegiatanServices.findKegiatanNONByRekapitulasiID(idr,r.getWaktuKegiatan().getWaktuRekapitulasi(),ida));
        mav.setViewName("rekapitulasi/halamanRekapitulasiKegiatanSet");
        return mav;
    }
    @RequestMapping(value = "/rekapitulasimemilihkegiatan")
    public String rekapitulasiMemilihKegiatanP(@Param("id")long id,@Param("idr")long idr){
        KegiatanRekapitulasi kr = new KegiatanRekapitulasi();
        kr.setKegiatan(kegiatanServices.getKegiatanById(id));
        kr.setRekapitulasi(rekapitulasiServices.getRekapitulasiById(idr));
        kegiatanRekapitulasiService.SaveOrUpdateKegiatanRekapitulasi(kr);
        TargetPenilaian tr =  new TargetPenilaian();
        tr.setRekapitulasi(rekapitulasiServices.getRekapitulasiById(idr));
        tr.setKegiatan(kegiatanServices.getKegiatanById(id));
        tr.setVolTarget(0L);
        tr.setNilaiTarget(0L);
        tr.setSkorTarget(0L);
        targetPenilaianServices.SaveOrUpdateTargetPenilaian(tr);
        return "redirect:rekapitulasikegiatanset?idr="+idr;
    }

}
