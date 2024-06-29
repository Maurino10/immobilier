package com.bien.Immobilier.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bien.Immobilier.Model.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String>{
    @Query(value = "SELECT * FROM admin WHERE login = :login and password = :password", nativeQuery = true)
    public Admin findBylogin(@Param("login") String login, @Param("password") String password);
}
