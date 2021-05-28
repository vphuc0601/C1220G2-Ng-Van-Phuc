package com.example.case_study.service;

import com.example.case_study.entity.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {
    public Page<Contract> search(String keyword, Pageable pageable);

    Contract findById(Long id);

    void save(Contract contract);

    void remove(Long id);

    Page<Contract> findAll(Pageable pageable);

    Page<Contract> findByInputText(String inputSearch, Pageable pageable);

    double getTotalMoney(Contract contract);

}
