package com.masterpiece.rentService.model.to;

import com.masterpiece.rentService.model.Status;

import java.math.BigDecimal;
import java.util.Set;

public class LotTo {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;

    private String image;

    private Boolean available;

    private Set<Status> statuses;

    public LotTo(Integer id, String name, String description, BigDecimal price, String image, Boolean available) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.available = available;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public Boolean getAvailable() {
        return available;
    }
}
