package com.joaocastro.newsletter.repository;

import com.joaocastro.newsletter.model.NewsletterCustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param; // <--- GARANTA ESTE IMPORT
import org.springframework.stereotype.Repository;

@Repository
public interface NewsletterCustomerRepository extends JpaRepository <NewsletterCustomerModel, Long> {

    @Procedure(procedureName = "PRC_REGISTER_CLIENT", outputParameterName = "P_ID")
    Long registerClient(
            @Param("P_NAME") String name,
            @Param("P_MAIL") String mail
    );

}
