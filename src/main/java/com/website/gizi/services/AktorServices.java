package com.website.gizi.services;

import com.website.gizi.dao.AktorDao;
import com.website.gizi.model.Aktor;
import com.website.gizi.model.Login;
import com.website.gizi.repository.AktorRepository;
import com.website.gizi.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class AktorServices implements AktorDao {
    @Autowired
    AktorRepository aktorRepository;
    @Autowired
    LoginRepository loginRepository;
    @Override
    public List<Aktor> getAllAktor() {
        List<Aktor> al = new ArrayList<>();
        aktorRepository.findAll().forEach(al::add);
        return al;
    }

    @Override
    public Aktor getAktorById(long id) {
        Aktor a = aktorRepository.findById(id).get();

        return a;
    }

    @Override
    public void SaveOrUpdateAktor(Aktor a, Login l) {
        try{
            l = loginRepository.save(l);
            a.setLogin(l);
            aktorRepository.save(a);
        }catch (Exception e){
            System.out.println("Erornya karna : " +e);
        }
    }

    @Override
    public void deleteAktorById(long id) {
        aktorRepository.deleteById(id);
    }

    @Override
    public void deleteAktor(Aktor a) {
        aktorRepository.delete(a);
    }
}
