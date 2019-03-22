package com.website.gizi.controller;

import com.website.gizi.model.Aktor;
import com.website.gizi.model.Login;
import com.website.gizi.request.TambahMemberRequest;
import com.website.gizi.response.ApiResponse;
import com.website.gizi.services.AktorServices;
import com.website.gizi.services.LoginServices;
import com.website.gizi.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AktorController {

    @Autowired
    AktorServices aktorServices;
    @Autowired
    LoginServices loginServices;
    @Autowired
    RoleServices roleServices;

    @RequestMapping(value = "/tambahmember",method = RequestMethod.POST)
    public ResponseEntity<?> tambahmember(@RequestBody TambahMemberRequest tambahMemberRequest){
        if(loginServices.findByUsernameAktor(tambahMemberRequest.getUsernameAktor())!=null){

            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
        }else {
        Login login = new Login();
        login.setUsernameAktor(tambahMemberRequest.getUsernameAktor());
        login.setPasswordAktor(tambahMemberRequest.getPasswordAktor());
        login.setRole(roleServices.getRoleById(1));
        Login ll = loginServices.SaveOrUpdateLogin(login);
        Aktor aktor = new Aktor();
        aktor.setLogin(ll);
        aktor.setNamaAwal(tambahMemberRequest.getNamaAwal());
        aktor.setNamaAkhir(tambahMemberRequest.getNamaAkhir());
        aktor.setAlamat(tambahMemberRequest.getAlamat());
        aktor.setNoHp(tambahMemberRequest.getNoHp());
        Aktor result = aktorServices.SaveOrUpdateAktor(aktor);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getNamaAwal()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true,"asdasdadasd"));
    }}
    @RequestMapping(value = "/memberall",method = RequestMethod.GET)
    public List<Aktor> memberall(){

        return aktorServices.getAllAktor();
    }

    @RequestMapping(value = "/jumlahmember",method = RequestMethod.POST)
    public String JumlahMember(@RequestParam ("namarole") String namarole){
        return String.valueOf(loginServices.findSummember(namarole));
    }
}
