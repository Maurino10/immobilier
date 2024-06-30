package com.bien.Immobilier.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bien.Immobilier.Model.Proprietaire;

@Repository
public interface ProprietaireRepository extends JpaRepository<Proprietaire, String> {
    @Query(value = "SELECT * FROM proprietaire WHERE tel = :numero", nativeQuery = true)
     Proprietaire findByNumero(@Param("numero") String numero);
}
