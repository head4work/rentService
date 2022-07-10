package com.masterpiece.rentService.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "rents")
public class Rent extends AbstractNamedEntity {

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


    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "rent_statuses")
    @Column(name = "statuses")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    private Set<Status> statuses;


    public Rent() {

    }

    public Rent(Integer id, String name, String description, LocalDateTime createDateTime, String image, Boolean available, Set<Status> statuses) {
        super(id, name);
        this.description = description;
        CreateDateTime = createDateTime;
        this.image = image;
        this.available = available;
        this.statuses = statuses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public LocalDateTime getCreateDateTime() {
        return CreateDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        CreateDateTime = createDateTime;
    }
}
