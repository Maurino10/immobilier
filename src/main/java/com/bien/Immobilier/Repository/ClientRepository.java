package com.bien.Immobilier.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bien.Immobilier.Model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    @Query(value = "SELECT * FROM client WHERE email = :email", nativeQuery = true)
    Client findByEmail(@Param("email") String email);
}
