package com.demo.ticket.controller;

import com.demo.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/buyTicket/{id}")
    public String buyTicket(@PathVariable("id") Long id){
        System.out.println("访问 /buyTicket/"+id);
        return ticketService.buyTicket(id);
    }
}
