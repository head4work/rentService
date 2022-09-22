package com.masterpiece.rentService.model;

import java.time.LocalDateTime;
import java.util.Set;

public class AjaxResponseBody {

    private String msg;
    private Set<LocalDateTime> disableDates;

    public AjaxResponseBody(String msg, Set<LocalDateTime> disableDates) {
        this.msg = msg;
        this.disableDates = disableDates;
    }

    public AjaxResponseBody() {
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Set<LocalDateTime> getDisableDates() {
        return disableDates;
    }

    public void setDisableDates(Set<LocalDateTime> disableDates) {
        this.disableDates = disableDates;
    }
}
