package com.masterpiece.rentService.model;

import java.util.Set;

public class Rent extends AbstractNamedEntity {

    private String description;

    private String image;

    private Boolean available;

    private Set<Status> statuses;

    public Rent(Integer id, String name, String description, String image, Boolean available, Set<Status> statuses) {
        super(id, name);
        this.description = description;
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
}
