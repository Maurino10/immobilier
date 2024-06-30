package com.bien.Immobilier.Repository;

import com.bien.Immobilier.Model.Bien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
 @Repository
public interface BienRepository extends JpaRepository<Bien, String> {
    @Query(value = "SELECT * FROM bien WHERE id_proprietaire = :idPropretaire", nativeQuery = true)
    public List<Bien> findAllProprietaire(@Param("idPropretaire") String idProprietaire);
}
