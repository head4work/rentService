package com.masterpiece.rentService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "lots")
public class Lot extends AbstractNamedEntity {

    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 300, message = "{Size.Lot.Description}")
    private String description;

    @Column(name = "price")
    @NotNull(message = "{NotNull.Lot.Price}")
    @Digits(integer = 3, fraction = 2)
    @DecimalMin("0.1")
    @DecimalMax("999.99")
    private BigDecimal price;

    /*@CollectionTable(name = "rents")
    @JoinColumn(name = "user_id")
    @ElementCollection(fetch = FetchType.LAZY)
    ConcurrentHashMap<LocalDate, Integer> rents;*/

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @Column(name = "create_date_time", nullable = false, columnDefinition = "timestamp default now()", updatable = false)
    @NotNull
    private LocalDateTime CreateDateTime;

    @Column(name = "images")
    private String image;


    @OneToMany(mappedBy = "lot", fetch = FetchType.EAGER)
    @OrderBy("startRentDate DESC")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonManagedReference
    private Set<Rent> rents;

    public Lot() {
    }

    public Lot(LocalDateTime createDateTime) {
        CreateDateTime = createDateTime;
    }

    public Lot(Integer id, String name, String description, BigDecimal price, LocalDateTime createDateTime, String image, Set<Rent> rents) {
        super(id, name);
        this.description = description;
        this.price = price;
        CreateDateTime = createDateTime;
        this.image = image;
        this.rents = rents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        CreateDateTime = createDateTime;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Set<Rent> getRents() {
        return rents;
    }

    public void setRents(Set<Rent> rents) {
        this.rents = rents;
    }
}
