package com.website.gizi.controller;

import com.website.gizi.services.WaktuKegiatanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WaktuKegiatanController {
    @Autowired
    WaktuKegiatanServices waktuKegiatanServices;


}
