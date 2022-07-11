package com.masterpiece.rentService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

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


}
