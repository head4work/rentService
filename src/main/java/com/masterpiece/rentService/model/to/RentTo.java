package com.masterpiece.rentService.model.to;

import com.masterpiece.rentService.model.AbstractNamedEntity;
import com.masterpiece.rentService.model.Status;

import java.util.Set;

public class RentTo extends AbstractNamedEntity {

    private Boolean available;

    private Set<Status> statuses;

}
