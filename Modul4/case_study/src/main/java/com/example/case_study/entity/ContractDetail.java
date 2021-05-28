package com.example.case_study.entity;
import javax.persistence.*;

@Entity
@Table(name = "contract_detail")
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "quantity", columnDefinition = "VARCHAR(255)")
    private String quantity;

    @OneToOne
    @JoinColumn(name = "attach_service_id", referencedColumnName = "id")
    private AttachService attachService;

    @ManyToOne
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;

    public ContractDetail() {
    }

    public ContractDetail(Long id, String quantity, AttachService attachService, Contract contract) {
        this.id = id;
        this.quantity = quantity;
        this.attachService = attachService;
        this.contract = contract;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
