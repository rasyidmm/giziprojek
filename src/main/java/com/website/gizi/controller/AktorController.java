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
        return new ModelAndView("member/halamanMember", "memberlist", aktorServices.findAllByActive());
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
    public String memberupdate(@ModelAttribute("Aktor") Aktor a, @ModelAttribute("Login") Login l, @RequestParam("id") long id, @RequestParam("idlg") long idlg) {
        a.setId(id);
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
        int size = loginServices.cekPassowwrdAndAktor_Id(id, password).size();
        if (size > 0) {
//            return new ModelAndView("member/halamanMemberDetail","memberdetail",aktorServices.getAktorById(id));
            return new ModelAndView("member/halamanMemberPassword", "passwordsiapupdate", loginServices.getLoginById(id));
        } else {
//            return new ModelAndView("member/halamanMemberPassword","passwordsiapupdate",loginServices.getLoginById(id));
            return new ModelAndView("member/halamanMemberDetail", "memberdetail", aktorServices.getAktorById(id));
        }
    }

    @RequestMapping(value = "/gantipasswordmember")
    public String gantipassword(@RequestParam("id") long id, @RequestParam("password") String password) {
        Login login = loginServices.getLoginById(id);
        login.setPasswordAktor(password);
        login.setUsernameAktor(login.getUsernameAktor());
        login.setRole(login.getRole());
        loginServices.SaveOrUpdateLogin(login);
        return "redirect:member";
    }
}

