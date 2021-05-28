package com.example.case_study.entity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "customer_id", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Customer ID not empty.")
    @Pattern(regexp = "^(KH-)\\d{4}$",message = "Format must be KH-xxxx.")
    private String customerId;

    @NotBlank(message = "Name customer not empty.")
    @Column(name = "customer_name",columnDefinition = "VARCHAR(255)")
    private String customerName;


    @Column(name = "customer_birthday", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date customerBirthday;

    @Column(name = "customer_gender",columnDefinition = "VARCHAR(255)")
    private String customerGender;

    @Column(name = "customer_id_card", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "ID Card not empty.")
    @Pattern(regexp = "^[0-9]{9}", message = "ID Card must be 9 number.")
    private String customerIdCard;

    @Column(name = "customer_phone", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Phone not empty.")
    @Pattern(regexp = "^(03|05|07|08|09|01[2|6|8|9])+([0-9]{8})$", message = "Phone incorrect format.")
    private String customerPhone;

    @Column(name = "customer_email", columnDefinition = "VARCHAR(255)")
    @NotBlank(message = "Email not empty.")
    @Pattern(regexp = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$", message = "Email incorrect format.")
    private String customerEmail;

    @NotBlank(message = "Address not empty.")
    @Column(name = "customer_address",columnDefinition = "VARCHAR(255)")
    @Pattern(regexp = "^[a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\\\s]$"
                  , message = "Name incorrect.")
    private String customerAddress;

//    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
//    private Set<CustomerType> customerType;
    @ManyToOne
    @JoinColumn(name = "customer_type_id", referencedColumnName = "id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<Contract> contract;

    public Customer() {
    }

    public Customer(Long id, String customerId, String customerName, Date customerBirthday, String customerGender,
                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress)
    {
        this.id = id;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Date getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(Date customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Customer.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        LocalDate today = LocalDate.now();
        Date birth = customer.getCustomerBirthday();
        if (birth == null) {
            errors.rejectValue("customerBirthday", "DateNotNull");
        } else {
            LocalDate birthLocal =  birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(birthLocal, today).getYears()<18) {
                errors.rejectValue("customerBirthday", "DateCustomer");
            }
        }
    }
}
