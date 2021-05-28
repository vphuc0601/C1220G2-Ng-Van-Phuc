package com.example.case_study.service.impl;


import com.example.case_study.entity.Contract;
import com.example.case_study.entity.RentType;
import com.example.case_study.repository.ContractRepository;
import com.example.case_study.repository.RentTypeRepository;
import com.example.case_study.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

//import java.time.LocalDate;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private RentTypeRepository rentTypeRepository;

    @Override
    public Page<Contract> search(String keyword, Pageable pageable) {
        return contractRepository.search(keyword, pageable);
    }

    @Override
    public Contract findById(Long id) {
        return contractRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contract.setTotalMoney(getTotalMoney(contract));
        contractRepository.save(contract);

    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Page<Contract> findByInputText(String inputSearch, Pageable pageable) {
        return null;
    }

    @Override
    public double getTotalMoney(Contract contract) {
        double totalMoney = 0;
        List<RentType> rentTypeList = rentTypeRepository.findAll();
        LocalDate starDay = contract.getStartDate();
        LocalDate endDay = contract.getEndDate();
        int days = Math.toIntExact(ChronoUnit.DAYS.between(starDay, endDay));
        if(days <= 31) {
            totalMoney += days * rentTypeList.get(1).getCost();

            System.out.println(totalMoney);
        }else{
            if (days > 31 && days < 365) {
                totalMoney += days * rentTypeList.get(2).getCost();
            } else {
                if (days > 365) {
                    totalMoney += days * rentTypeList.get(3).getCost();
                } else {
                    totalMoney += days * rentTypeList.get(4).getCost();
                }
            }
        }
        return totalMoney;
    }
}
