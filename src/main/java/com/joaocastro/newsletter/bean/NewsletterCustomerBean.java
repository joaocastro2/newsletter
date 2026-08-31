package com.joaocastro.newsletter.bean;

import com.joaocastro.newsletter.service.NewsletterCustomerService;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component("newsletterCustomerBean")
@Scope("view")
public class NewsletterCustomerBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private final NewsletterCustomerService customerService;

    private String name;
    private String mail;

    public NewsletterCustomerBean(NewsletterCustomerService customerService) {
        this.customerService = customerService;
    }

    public void cadastrar() {
        try {
            Long newId = customerService.registerClient(name, mail);

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,
                            "Sucesso!", "Cliente cadastrado com ID: " + newId));

            this.name = null;
            this.mail = null;
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Erro!", "Falha ao cadastrar cliente: " + e.getMessage()));
        }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
}