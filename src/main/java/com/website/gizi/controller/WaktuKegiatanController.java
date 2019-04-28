package com.website.gizi.controller;

import com.website.gizi.model.WaktuKegiatan;
import com.website.gizi.services.RekapitulasiServices;
import com.website.gizi.services.WaktuKegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class WaktuKegiatanController {
    @Autowired
    WaktuKegiatanServices waktuKegiatanServices;

    @Autowired
    RekapitulasiServices rekapitulasimemberset;

    @RequestMapping(value = "/rekapitulasiwaktu")
    public ModelAndView rekapitulasiwaktu() {
        return new ModelAndView("waktukegiatan/halamanWaktuKegiatan", "waktukegiatanlist", waktuKegiatanServices.getAllWaktuKegiatan());
    }

    @RequestMapping(value = "/rekapitulasiwaktuset")
    public String rekapitulasiWaktuSet() {
        return "waktukegiatan/halamanWaktuKegiatanSet";
    }

    @RequestMapping(value = "/rekapitulasiwaktuset", method = RequestMethod.POST)
    public String rekapitulasiWaktuproses(@ModelAttribute("WaktuKegiatan") WaktuKegiatan waktuKegiatan, @Param("waktuRekapitulasii") String waktuRekapitulasii) {
        List<WaktuKegiatan> dsfsdfds = waktuKegiatanServices.findWaktuKegiatanByWakturekapitulasi(waktuRekapitulasii);
        if (0 == dsfsdfds.size()) {
            waktuKegiatan.setWaktuRekapitulasi(waktuRekapitulasii);
            waktuKegiatanServices.SaveOrUpdateWaktuKegiatan(waktuKegiatan);
        }
        return "redirect:rekapitulasiwaktu";
    }

    @RequestMapping(value = "/rekapitulasiwaktudetail")
    public ModelAndView rekapitulasimemberSet(@Param("id") long id) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("rekapitulasidetail", waktuKegiatanServices.getWaktuKegiatanById(id));
        mav.setViewName("waktukegiatan/halamanWaktuKegiatanDetail");
        return mav;
    }

//    @RequestMapping(value = "/rekapitulasimemberset",method = RequestMethod.POST)
//    public String Proses(){
//        return"";
//    }


}
