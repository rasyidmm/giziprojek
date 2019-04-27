package com.website.gizi.controller;

import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import com.website.gizi.model.*;
import com.website.gizi.services.*;
import jdk.nashorn.internal.objects.ArrayBufferView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

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
    public ModelAndView rekapitulasi() {
        return new ModelAndView("rekapitulasi/halamanRekapitulasi", "rekapitulasilist", rekapitulasiServices.getAllRekapitulasi());
    }

    @RequestMapping(value = "/rekapitulasimemberset")
    public ModelAndView rekapitulasiCreate(@Param("id") long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("wakturekapitulasi", waktuKegiatanServices.getWaktuKegiatanById(id));
        mav.addObject("listaktorSet", aktorServices.findAktorByWaktu(id));
        mav.setViewName("rekapitulasi/halamanRekapitulasiMember");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasimembersett")
    public ModelAndView RekapitulasiMemberSet(@Param("id") long id, @Param("ids") long ids) {
        Aktor a = aktorServices.getAktorById(id);
        WaktuKegiatan wk = waktuKegiatanServices.getWaktuKegiatanById(ids);
        Rekapitulasi rekapitulasi = new Rekapitulasi();
        rekapitulasi.setNamaRekapitulasi(a.getNamaAkhir() + " " + a.getNamaAkhir() + " " + (wk.getWaktuRekapitulasi()));
        rekapitulasi.setStatus("Proses");
        rekapitulasi.setCreateDate(new Date());
        rekapitulasi.setAktor(a);
        rekapitulasi.setWaktuKegiatan(wk);
        rekapitulasiServices.SaveOrUpdateRekapitulasi(rekapitulasi);
        Rekapitulasi grer = rekapitulasiServices.findRekapitulasiByAktorAndWaktuKegiatan(id, ids);
        long idr = grer.getId();
        ModelAndView mav = new ModelAndView();
        mav.addObject("idr", idr);
        mav.addObject("ida", a.getId());
        mav.setViewName("redirect:rekapitulasikegiatanset");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasikegiatanset")
    public ModelAndView rekapitulasiKegiatanSet(@Param("idr") long idr, @Param("ida") long ida) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("rekapitulasipilih", rekapitulasiServices.getRekapitulasiById(idr));
        mav.addObject("kegiatanterpilihlist", kegiatanServices.findKegiatanByRekapitulasiID(idr));
        mav.addObject("aktorpilih", aktorServices.getAktorById(ida));
        mav.setViewName("rekapitulasi/halamanRekapitulasiKegiatan");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasimemilih")
    public ModelAndView rekapitulasiMemilihKegiatan(@Param("idr") long idr, @Param("ida") long ida) {
        Rekapitulasi r = rekapitulasiServices.getRekapitulasiById(idr);
        ModelAndView mav = new ModelAndView();
        mav.addObject("rekapitulasipilih", rekapitulasiServices.getRekapitulasiById(idr));
        mav.addObject("kegiatannonmilih", kegiatanServices.findKegiatanNONByRekapitulasiID(r.getWaktuKegiatan().getWaktuRekapitulasi(), ida));
        mav.addObject("aktorpilih", aktorServices.getAktorById(ida));
        mav.setViewName("rekapitulasi/halamanRekapitulasiKegiatanSet");
        return mav;
    }

    @RequestMapping(value = "/rekapitulasimemilihkegiatan")
    public ModelAndView rekapitulasiMemilihKegiatanP(@Param("id") long id, @Param("idr") long idr, @Param("ida") long ida) {
        ModelAndView mav = new ModelAndView();
        KegiatanRekapitulasi kr = new KegiatanRekapitulasi();
        kr.setStatus("Proses");
        kr.setKegiatan(kegiatanServices.getKegiatanById(id));
        kr.setRekapitulasi(rekapitulasiServices.getRekapitulasiById(idr));
        kr.setCreateDate(new Date());
        kegiatanRekapitulasiService.SaveOrUpdateKegiatanRekapitulasi(kr);
        TargetPenilaian tr = new TargetPenilaian();
        tr.setStatus("Proses");
        tr.setRekapitulasi(rekapitulasiServices.getRekapitulasiById(idr));
        tr.setKegiatan(kegiatanServices.getKegiatanById(id));
        tr.setCreateDate(new Date());
        tr.setVolTarget(0L);
        tr.setNilaiTarget(0L);
        tr.setSkorTarget(0L);
        targetPenilaianServices.SaveOrUpdateTargetPenilaian(tr);
        mav.addObject("idr", idr);
        mav.addObject("ida", ida);
        mav.setViewName("redirect:rekapitulasikegiatanset");
        return mav;
    }

    @RequestMapping(value = "/membuatselesai")
    public String prosesMebuatRekapitulasiSelesai(@Param("id") long id) {
        try {
            List<KegiatanRekapitulasi> kr = kegiatanRekapitulasiService.findAllByRekapitulasi(id);
            int sizekr = kegiatanRekapitulasiService.findAllByRekapitulasi(id).size();
            for (int i = 0; i < sizekr; i++) {
                KegiatanRekapitulasi krid = kegiatanRekapitulasiService.getKegiatanRekapitulasiById(kr.get(1).getId());
                krid.setStatus("Selesai");
                krid.setId(krid.getId());
                kegiatanRekapitulasiService.SaveOrUpdateKegiatanRekapitulasi(krid);
            }
            List<TargetPenilaian> tp = targetPenilaianServices.findAllByRekapitulasi(id);
            int sizetp = targetPenilaianServices.findAllByRekapitulasi(id).size();
            for (int t = 0; t > sizetp; t++) {
                TargetPenilaian tpid = targetPenilaianServices.getTargetPenilaianById(tp.get(t).getId());
                tpid.setStatus("Selesai");
                tpid.setId(tpid.getId());
                targetPenilaianServices.SaveOrUpdateTargetPenilaian(tpid);
            }
            Rekapitulasi rid = rekapitulasiServices.findByIdAndStatus(id);
            rid.setStatus("Selesai");
            rid.setId(rid.getId());
            rekapitulasiServices.SaveOrUpdateRekapitulasi(rid);
        }catch (Exception e){

        }
        return ("redirect:rekapitulasi");
    }


}
