package com.joaocastro.newsletter.service;

import com.joaocastro.newsletter.repository.NewsletterCustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NewsletterCustomerService {

    @Autowired
    private NewsletterCustomerRepository customerRepository;

    @Transactional
    public Long registerClient(String nome, String email) {
        return customerRepository.registerClient(nome, email);
    }

}
