package com.masterpiece.rentService.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "rents")
public class Rent extends AbstractBaseEntity {

    @Column(name = "date_start", nullable = false)
    @NotNull
    private LocalDateTime startRentDate;

    @Column(name = "date_end", nullable = false)
    @NotNull
    private LocalDateTime endRentDate;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    //@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lot_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Lot lot;
/*
 // RentTo or LotTo
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "rent_statuses")
    @Column(name = "statuses")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Status> statuses;
*/

    public Rent() {
    }

    public Rent(LocalDateTime startRentDate, LocalDateTime endRentDate, Lot lot) {
        this.startRentDate = startRentDate;
        this.endRentDate = endRentDate;
        this.lot = lot;
    }

    public Rent(Integer id, LocalDateTime startRent, LocalDateTime endRent) {
        super(id);
        this.startRentDate = startRent;
        this.endRentDate = endRent;
    }

    public LocalDateTime getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(LocalDateTime startRent) {
        this.startRentDate = startRent;
    }

    public LocalDateTime getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(LocalDateTime endRent) {
        this.endRentDate = endRent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Lot getLot() {
        return lot;
    }

    public void setLot(Lot lot) {
        this.lot = lot;
    }

}
