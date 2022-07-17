package com.masterpiece.rentService.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "rents")
public class Rent extends AbstractNamedEntity {

    @Column(name = "date_start", nullable = false)
    @NotNull
    private LocalDateTime startRent;

    @Column(name = "date_end", nullable = false)
    @NotNull
    private LocalDateTime endRent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

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

    public Rent(Integer id, String name, LocalDateTime startRent, LocalDateTime endRent) {
        super(id, name);
        this.startRent = startRent;
        this.endRent = endRent;
    }

    public LocalDateTime getStartRent() {
        return startRent;
    }

    public void setStartRent(LocalDateTime startRent) {
        this.startRent = startRent;
    }

    public LocalDateTime getEndRent() {
        return endRent;
    }

    public void setEndRent(LocalDateTime endRent) {
        this.endRent = endRent;
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
