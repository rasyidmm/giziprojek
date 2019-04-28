package com.website.gizi.dao;

import com.website.gizi.model.Login;

import java.util.List;

public interface LoginDao {
    public List<Login> getAllLogin();

    public Login getLoginById(long id);

    public Login SaveOrUpdateLogin(Login a);

    public void deleteLoginById(long id);

    public void deleteLogin(Login a);
}
