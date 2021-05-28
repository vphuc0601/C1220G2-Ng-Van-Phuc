package com.example.case_study.entity;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ID not empty.")
    @Pattern(regexp = "^(NV-)\\d{4}$", message = "Employee Id must be NV-xxxx.")
    @Column(name = "employee_id", columnDefinition = "VARCHAR(255)")
    private String employeeId;

    @NotBlank(message = "Name not empty.")
    @Column(name = "employee_name",columnDefinition = "VARCHAR(255)")
    private String employeeName;

    @PastOrPresent
    @Column(name = "employee_birthday", columnDefinition = "DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date employeeBirthday;

    @NotBlank(message = "Not empty.")
    @Pattern(regexp = "^[0-9]{9}", message = "ID Card must be 10 number.")
    @Column(name = "employee_id_card", columnDefinition = "VARCHAR(255)")
    private String employeeIdCard;

    @NotBlank(message = "Salary not Empty.")
    @Positive(message = "Salary incorrect.")
    @Column(name = "employee_salary", columnDefinition = "DOUBLE")
    private String employeeSalary;

    @NotBlank(message = "Phone not empty.")
    @Pattern(regexp = "^0[0-9]{9}$", message = "Phone incorrect format.")
    @Column(name = "employee_phone", columnDefinition = "INT")
    private String employeePhone;

    @NotBlank(message = "Email not empty.")
    @Pattern(regexp = "^[a-z0-9_]+[a-z0-9]@([a-z0-9]+\\.)[a-z]+(|\\.[a-z]+)$", message = "Email incorrect format.")
    @Column(name = "employee_email", columnDefinition = "VARCHAR(255)")
    private String employeeEmail;

    @Column(name = "employee_address", columnDefinition = "VARCHAR(255)")
    private String employeeAddress;
    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "division_id", referencedColumnName = "id")
    private Division division;

    @ManyToOne
    @JoinColumn(name = "education_degree_id", referencedColumnName = "id")
    private EducationDegree educationDegree;

   @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
   private Set<Contract> contract;

    @OneToOne
    @JoinColumn(name = "user_name", referencedColumnName = "user_name" )
    private User user;

    public Employee() {
    }

    public Employee(Long id, String employeeId, String employeeName, Date employeeBirthday, String employeeIdCard,
                    String employeeSalary, String employeePhone, String employeeEmail, String employeeAddress) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeIdCard = employeeIdCard;
        this.employeeSalary = employeeSalary;
        this.employeePhone = employeePhone;
        this.employeeEmail = employeeEmail;
        this.employeeAddress = employeeAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(String employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Set<Contract> getContract() {
        return contract;
    }

    public void setContract(Set<Contract> contract) {
        this.contract = contract;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Employee.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Employee employee = (Employee) target;
        LocalDate today = LocalDate.now();
        Date birth = employee.getEmployeeBirthday();
        if (birth == null) {
            errors.rejectValue("employeeBirthday", "DateNotNull");
        } else {
            LocalDate birthLocal =  birth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            if (Period.between(birthLocal, today).getYears()<18) {
                errors.rejectValue("employeeBirthday", "DateCustomer");
            }
        }
    }
}
