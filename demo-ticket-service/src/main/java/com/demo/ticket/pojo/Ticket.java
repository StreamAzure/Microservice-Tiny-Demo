package com.demo.ticket.pojo;

import lombok.Data;

@Data
public class Ticket {
    private String userInfo;
    private String station;

    public Ticket(String userInfo, String station) {
        this.userInfo = userInfo;
        this.station = station;
    }

    public String toString(){
        return userInfo + ", station " + station;
    }
}
