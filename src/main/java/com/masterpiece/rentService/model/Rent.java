package com.masterpiece.rentService.model;

import java.util.Set;

public class Rent extends AbstractNamedEntity {

    private String description;

    private String image;

    private Boolean available;

    private Set<Status> statuses;


}
