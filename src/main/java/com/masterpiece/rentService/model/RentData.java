package com.masterpiece.rentService.model;

import java.time.LocalDateTime;

public class RentData {
    private LocalDateTime startRentDate;
    private LocalDateTime endRentDate;
    Integer lotId;

    public RentData(LocalDateTime startRentDate, LocalDateTime endRentDate, Integer lotId) {
        this.startRentDate = startRentDate;
        this.endRentDate = endRentDate;
        this.lotId = lotId;
    }

    public LocalDateTime getStartRentDate() {
        return startRentDate;
    }

    public void setStartRentDate(LocalDateTime startRentDate) {
        this.startRentDate = startRentDate;
    }

    public LocalDateTime getEndRentDate() {
        return endRentDate;
    }

    public void setEndRentDate(LocalDateTime endRentDate) {
        this.endRentDate = endRentDate;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }
}
