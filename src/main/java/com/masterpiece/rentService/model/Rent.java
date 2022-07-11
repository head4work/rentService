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

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "rent_statuses")
    @Column(name = "statuses")
    @ElementCollection(fetch = FetchType.EAGER)
//    @Fetch(FetchMode.SUBSELECT)
    private Set<Status> statuses;

    public Rent() {

    }


}
