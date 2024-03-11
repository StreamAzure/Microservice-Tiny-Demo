package com.demo.ticket.pojo;

import lombok.Data;
import com.demo.user.pojo.User;

@Data
public class Ticket {
    private User user;
    private String station;

    public String toString(){
        return "User " + user.getId() + ", name " + user.getName() + ", station " + station;
    }
}
