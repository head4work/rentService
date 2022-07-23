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

}
