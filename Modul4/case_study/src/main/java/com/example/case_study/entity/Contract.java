package com.example.case_study.entity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Set;

@Entity
@Table(name = "contract")
public class Contract implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Must be the present or future date")
    @Column(columnDefinition = "DATE")
    private LocalDate startDate;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Must be the future date")
    @Column(columnDefinition = "DATE")
    private LocalDate endDate;

    @NotNull(message = "Deposit not empty")
    @Positive(message = "Deposit incorrect format")
    @Column(name = "contract_deposit", columnDefinition = "DOUBLE")
    private Double deposit;

//    @NotNull(message = "Not empty")
    @Positive(message = "Total money incorrect format")
    @Column(name = "contract_total_money", columnDefinition = "DOUBLE")
    private Double totalMoney;

    public Contract() {
    }

    public Contract(Long id, LocalDate startDate, LocalDate endDate, Double deposit, Double totalMoney, Set<ContractDetail> contractDetail, Service service, Employee employee, Customer customer) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.contractDetail = contractDetail;
        this.service = service;
        this.employee = employee;
        this.customer = customer;
    }

    @OneToMany(mappedBy = "contract", cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetail;

    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return Contract.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Contract contract = (Contract) target;

        LocalDate localDateInput1 = contract.startDate;
        LocalDate localDateInput2 = contract.endDate;


        if (localDateInput1 == null || localDateInput2 == null) {
            errors.rejectValue("startDate", "DateNotNull");
            errors.rejectValue("endDate", "DateNotNull");
        }   else {
            if (localDateInput2.isBefore(localDateInput1)) {
                errors.rejectValue("endDate", "EndDateMustAfterOrEqualStartDate");
            }
        }
    }
}
