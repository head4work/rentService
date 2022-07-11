package com.masterpiece.rentService.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "lots")
public class Lot extends AbstractNamedEntity {
    @Column(name = "description", nullable = false)
    @NotBlank
    @Size(min = 2, max = 120)
    private String description;

    @Column(name = "create_date_time", nullable = false)
    @NotNull
    private LocalDateTime CreateDateTime;

    @Column(name = "images")
    private String image;

    @Column(name = "available", nullable = false, columnDefinition = "bool default true")
    private Boolean available;

    @OneToMany(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<Rent> rents;

    public Lot() {
    }

    public Lot(Integer id, String name, String description, LocalDateTime createDateTime, String image, Boolean available) {
        super(id, name);
        this.description = description;
        CreateDateTime = createDateTime;
        this.image = image;
        this.available = available;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }
}
