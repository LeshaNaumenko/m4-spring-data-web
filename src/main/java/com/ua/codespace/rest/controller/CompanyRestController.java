/*
package com.ua.codespace.rest.controller;

import com.ua.codespace.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyRestController {
    @Autowired
     companyRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Company> getCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }
}
*/
