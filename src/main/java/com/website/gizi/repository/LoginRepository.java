package com.website.gizi.repository;

import com.website.gizi.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query(value = "select a.usernameAktor from Login a where a.usernameAktor =:usernameAktor")
    public Login findByUsernameAktor(@Param("usernameAktor") String usernameAktor);

    @Query(value = "select sum(a.aktor.id) from Login a where a.role.namaRole =:roleName")
    public Login findSummember(@Param("roleName") String roleName);

    @Query(value = "select a.passwordAktor from Login a where a.id =:id")
    public Login findPasswordByid(@Param("id") long id);

    @Query(value = "select * from login b where b.id =:id and b.password_aktor =:password", nativeQuery = true)
    public List<Login> cekPassowwrdAndAktor_Id(@Param("id") Long id, @Param("password") String password);
}
