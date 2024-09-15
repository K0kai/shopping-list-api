package com.kokai.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.kokai.converter.priorityStringToByteConverter;
import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;


@Entity
@Table(name = "ITEMS")
@DynamicUpdate
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 45 )
    private String name;

    private Byte quantity;

    @Convert(converter = priorityStringToByteConverter.class)
    private String priority;

    @Column(name = "bought")
    private Boolean status;


    @Column(name = "creation_date", updatable = false)
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate creationDate;

    public Items() {}

    public Items(Long id, String name, Byte quantity, String priority, Boolean status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.priority = priority;
        this.status = status;

    }

    public void onCreate() {
        if (this.name == null) {
            throw new RuntimeException("Nome não pode ser nulo");
        }
        if (this.quantity == null) {
            this.quantity = 1;
        }
        if (this.status == null) {
            this.status = false;
        }
        if (this.creationDate == null) {
            this.creationDate = LocalDate.now();
        }

    }



    public Long getId() {
        return id;
    }

    public Byte getQuantity() {
        return quantity;
    }

    @JsonGetter("priority")
    public String getPriority() {
        return switch (priority.toLowerCase()) {
            case "1" -> "high";
            case "2" -> "normal";
            case "3" -> "low";
            default -> priority;  // Return the actual value if already a string like "high"
        };
    }

    public Boolean getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Byte quantity) {
        this.quantity = quantity;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }


}
