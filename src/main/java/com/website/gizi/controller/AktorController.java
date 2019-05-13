package com.website.gizi.controller;

import com.website.gizi.model.Aktor;
import com.website.gizi.model.Login;
import com.website.gizi.services.AktorServices;
import com.website.gizi.services.LoginServices;
import com.website.gizi.services.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class AktorController {

    @Autowired
    AktorServices aktorServices;
    @Autowired
    LoginServices loginServices;
    @Autowired
    RoleServices roleServices;

    @RequestMapping(value = "/member")
    public ModelAndView halamanMember() {
        return new ModelAndView("member/halamanMember", "memberlist", aktorServices.findAllByStatusActive());
    }

    @RequestMapping(value = "/membertambah")
    public String halamanMemberTambah() {
        return "member/halamanMemberTambah";
    }

    @RequestMapping(value = "/membertambah", method = RequestMethod.POST)
    public String membertambah(@ModelAttribute("Aktor") Aktor a, @ModelAttribute("Login") Login l) {
        a.setStatus("Active");
        a.setCreateDate(new Date());
        l.setStatus("Active");
        l.setCreateDate(new Date());
        aktorServices.SaveOrUpdateAktor(a, l);
        return "redirect:member";
    }

    @RequestMapping(value = "/memberdetail")
    public ModelAndView halamanMemberDetail(@RequestParam("id") long id) {
        return new ModelAndView("member/halamanMemberDetail", "memberdetail", aktorServices.getAktorById(id));
    }

    @RequestMapping(value = "/memberupdate", method = RequestMethod.GET)
    public ModelAndView halamanMemberUpdate(@RequestParam("id") long id) {
        return new ModelAndView("member/halamanMemberUpdate", "memberupdate", aktorServices.getAktorById(id));
    }

    @RequestMapping(value = "/memberupdate", method = RequestMethod.POST)
    public String memberupdate(@ModelAttribute("Aktor") Aktor a, @RequestParam("id") long id, @RequestParam("idlg") long idlg) {
        Aktor aktor = aktorServices.getAktorById(id);
        a.setId(id);
        a.setCreateBy(aktor.getCreateBy());
        a.setCreateDate(aktor.getCreateDate());
        a.setKeterangan(aktor.getKeterangan());
        a.setStatus(aktor.getStatus());
        a.setUpdateDate(new Date());
        a.setUpdateBy(aktor.getUpdateBy());
        a.setLogin(loginServices.getLoginById(idlg));
        aktorServices.UpdateAktorMandiri(a);
        return "redirect:member";
    }

    @RequestMapping(value = "/memberdelete")
    public String memberDelete(@RequestParam("id") long id, @RequestParam("idlg") long idlg) {
        try {
            aktorServices.deleteAktorById(id);
            loginServices.deleteLoginById(idlg);
        } catch (Exception e) {
            System.out.println("Erornya karna : " + e);
        }
        return "redirect:member";
    }

    @RequestMapping(value = "/memberupdatelogin")
    public ModelAndView memberupdatelogin(@RequestParam("id") long id) {
        return new ModelAndView("member/halamanMemberPasswordChecker", "memberupdatelogin", loginServices.getLoginById(id));
    }

    @RequestMapping(value = "/cekpassword")
    public ModelAndView cekpassword(@RequestParam("id") long id, @RequestParam("password") String password) {
        int size = loginServices.findAllByAktorAndPasswordAktor(id, password).size();
        if (size > 0) {
//            return new ModelAndView("member/halamanMemberDetail","memberdetail",aktorServices.getAktorById(id));
            return new ModelAndView("member/halamanMemberPassword", "passwordsiapupdate", loginServices.getLoginById(id));
        } else {
//            return new ModelAndView("member/halamanMemberPassword","passwordsiapupdate",loginServices.getLoginById(id));
            return new ModelAndView("member/halamanMemberDetail", "memberdetail", aktorServices.getAktorById(id));
        }
    }

    @RequestMapping(value = "/gantipasswordmember")
    public String gantipassword(@ModelAttribute("Login")Login L,@RequestParam("id") long id, @RequestParam("password") String password) {
        Login login = loginServices.getLoginById(id);
        L.setId(login.getId());
        L.setCreateBy(login.getCreateBy());
        L.setCreateDate(login.getCreateDate());
        L.setStatus(login.getStatus());
        L.setKeterangan(login.getKeterangan());
        L.setUpdateBy(login.getUpdateBy());
        L.setUpdateDate(new Date());
        L.setPasswordAktor(password);
        L.setUsernameAktor(login.getUsernameAktor());
        L.setRole(login.getRole());
        loginServices.SaveOrUpdateLogin(L);
        return "redirect:member";
    }
    @RequestMapping(value = "deletememberstatus")
    public String deleteMemberStatus(@RequestParam("id")long id,@ModelAttribute("Aktor")Aktor a,@ModelAttribute("Login")Login l){
        Aktor aktor = aktorServices.getAktorById(id);
        Login login = loginServices.getLoginById(aktor.getLogin().getId());
        a.setId(id);
        a.setCreateBy(aktor.getCreateBy());
        a.setCreateDate(aktor.getCreateDate());
        a.setKeterangan(aktor.getKeterangan());
        a.setStatus("Deleted");
        a.setUpdateDate(new Date());
        a.setUpdateBy(aktor.getUpdateBy());
        a.setLogin(loginServices.getLoginById(login.getId()));
        a.setNamaAwal(aktor.getNamaAwal());
        a.setNamaAkhir(aktor.getNamaAkhir());
        a.setNomerSRT(aktor.getNomerSRT());
        a.setNoHp(aktor.getNoHp());
        a.setJenjangKarir(aktor.getJenjangKarir());
        a.setNama_foto(aktor.getNama_foto());
        a.setAlamat(aktor.getAlamat());
        a.setPendidikanTerahir(aktor.getPendidikanTerahir());

        l.setId(login.getId());
        l.setCreateBy(login.getCreateBy());
        l.setCreateDate(login.getCreateDate());
        l.setStatus("Deleted");
        l.setKeterangan(login.getKeterangan());
        l.setUpdateBy(login.getUpdateBy());
        l.setUpdateDate(new Date());
        l.setPasswordAktor(login.getPasswordAktor());
        l.setUsernameAktor(login.getUsernameAktor());
        l.setRole(login.getRole());
        aktorServices.SaveOrUpdateAktor(a,l);
        return "redirect:member";
    }
}

