package com.website.gizi.controller;

import com.website.gizi.model.Aktor;
import com.website.gizi.model.WaktuKegiatan;
import com.website.gizi.services.AktorServices;
import com.website.gizi.services.WaktuKegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class RestCController {

    @Autowired
    WaktuKegiatanServices waktuKegiatanServices;
    @Autowired
    AktorServices aktorServices;

    @RequestMapping(value = "/getwakturest")
    public String waktuKegiatans(@Param("id") long id, @Param("ids") long ids) {
        Aktor a = aktorServices.getAktorById(id);
        WaktuKegiatan wk = waktuKegiatanServices.getWaktuKegiatanById(ids);
        return String.valueOf(wk.getWaktuRekapitulasi().concat(a.getNamaAkhir()));
    }
}
