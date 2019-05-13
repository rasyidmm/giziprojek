package com.website.gizi.services;

import com.website.gizi.dao.LoginDao;
import com.website.gizi.model.Login;
import com.website.gizi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginServices implements LoginDao {
    @Autowired
    LoginRepository loginRepository;

    @Override
    public List<Login> getAllLogin() {
        List<Login> ll = new ArrayList<>();
        loginRepository.findAll().forEach(ll::add);
        return ll;
    }

    @Override
    public Login getLoginById(long id) {
        Login l = loginRepository.findById(id).get();
        return l;
    }

    @Override
    public Login SaveOrUpdateLogin(Login a) {
        loginRepository.save(a);
        return a;
    }

    @Override
    public void deleteLoginById(long id) {
        loginRepository.deleteById(id);
    }

    @Override
    public void deleteLogin(Login a) {
        loginRepository.delete(a);
    }

    public Login findByUsernameAktor(String usernameAktor) {
        return loginRepository.findByUsernameAktor(usernameAktor);
    }

    public Login findSummember(@Param("roleName") String roleName) {
        return loginRepository.findSummember(roleName);
    }

    public Login findPasswordByid(long id) {
        return loginRepository.findPasswordByid(id);
    }

    public List<Login> findAllByAktorAndPasswordAktor(Long id, String password) {
        return loginRepository.findAllByAktorAndPasswordAktor(id, password);
    }

}
