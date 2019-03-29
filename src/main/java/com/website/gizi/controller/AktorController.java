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

@Controller
public class AktorController {

    @Autowired
    AktorServices aktorServices;
    @Autowired
    LoginServices loginServices;
    @Autowired
    RoleServices roleServices;
//
//    @RequestMapping(value = "/tambahmember",method = RequestMethod.POST)
//    public ResponseEntity<?> tambahmember(@RequestBody TambahMemberRequest tambahMemberRequest){
//        if(loginServices.findByUsernameAktor(tambahMemberRequest.getUsernameAktor())!=null){
//
//            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
//        }else {
//        Login login = new Login();
//        login.setUsernameAktor(tambahMemberRequest.getUsernameAktor());
//        login.setPasswordAktor(tambahMemberRequest.getPasswordAktor());
//        login.setRole(roleServices.getRoleById(1));
//        Login ll = loginServices.SaveOrUpdateLogin(login);
//        Aktor aktor = new Aktor();
//        aktor.setLogin(ll);
//        aktor.setNamaAwal(tambahMemberRequest.getNamaAwal());
//        aktor.setNamaAkhir(tambahMemberRequest.getNamaAkhir());
//        aktor.setAlamat(tambahMemberRequest.getAlamat());
//        aktor.setNoHp(tambahMemberRequest.getNoHp());
//        Aktor result = aktorServices.SaveOrUpdateAktor(aktor);
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getNamaAwal()).toUri();
//        return ResponseEntity.created(location).body(new ApiResponse(true,"asdasdadasd"));
//    }}
//    @RequestMapping(value = "/memberall",method = RequestMethod.GET)
//    public List<Aktor> memberall(){
//
//        return aktorServices.getAllAktor();
//    }
//
//    @RequestMapping(value = "/jumlahmember",method = RequestMethod.POST)
//    public String JumlahMember(@RequestParam ("namarole") String namarole){
//        return String.valueOf(loginServices.findSummember(namarole));
//    }

    @RequestMapping(value = "/member")
    public ModelAndView halamanMember(){
        return new ModelAndView("member/halamanMember","memberlist",aktorServices.getAllAktor());
    }
    @RequestMapping(value = "/membertambah")
    public String halamanMemberTambah(){
        return "member/halamanMemberTambah";
    }
    @RequestMapping(value = "/membertambah",method = RequestMethod.POST)
    public String membertambah(@ModelAttribute("Aktor")Aktor a,@ModelAttribute("Login")Login l){
        aktorServices.SaveOrUpdateAktor(a,l);
        return "redirect:member";
    }
    @RequestMapping(value = "/memberdetail")
    public ModelAndView halamanMemberDetail(@RequestParam("id")long id){
        return new ModelAndView("member/halamanMemberDetail","memberdetail",aktorServices.getAktorById(id));
    }
    @RequestMapping(value ="/memberupdate",method = RequestMethod.GET)
    public ModelAndView halamanMemberUpdate(@RequestParam("id")long id){
        return new ModelAndView("member/halamanMemberUpdate","memberupdate",aktorServices.getAktorById(id));
    }
    @RequestMapping(value = "/memberupdate",method =  RequestMethod.POST)
    public String memberupdate(@ModelAttribute("Aktor")Aktor a,@ModelAttribute("Login")Login l,@RequestParam("id")long id,@RequestParam("idlg")long idlg){
        a.setId(id);
        a.setLogin(loginServices.getLoginById(idlg));
        aktorServices.UpdateAktorMandiri(a);
        return "redirect:member";
    }
    @RequestMapping(value = "/memberdelete")
    public String memberDelete(@RequestParam("id")long id,@RequestParam("idlg")long idlg){
        try {
            aktorServices.deleteAktorById(id);
            loginServices.deleteLoginById(idlg);
        }catch (Exception e){
            System.out.println("Erornya karna : " +e);
        }
        return "redirect:member";
    }

    @RequestMapping(value = "/memberupdatelogin")
    public ModelAndView memberupdatelogin(@RequestParam("id")long id){
        return new ModelAndView("member/halamanMemberPasswordChecker","memberupdatelogin",loginServices.getLoginById(id));
    }

    @RequestMapping(value = "/cekpassword")
    public ModelAndView cekpassword(@RequestParam("id")long id,@RequestParam("password")String password){
        Login login = loginServices.getLoginById(id);
        System.out.println(login.getPasswordAktor());
        System.out.println(password);
        if (password.toString() == login.getPasswordAktor().toString()) {
            return new ModelAndView("member/halamanMemberDetail","memberdetail",aktorServices.getAktorById(id));
        }else {
            return new ModelAndView("member/halamanMemberPassword","passwordsiapupdate",loginServices.getLoginById(id));
        }
    }
    @RequestMapping(value = "/gantipasswordmember")
    public String gantipassword(@RequestParam("id")long id,@RequestParam("password")String password){
        Login login = loginServices.getLoginById(id);
        login.setPasswordAktor(password);
        login.setUsernameAktor(login.getUsernameAktor());
        login.setRole(login.getRole());
        loginServices.SaveOrUpdateLogin(login);
        return "redirect:member";
    }
}

