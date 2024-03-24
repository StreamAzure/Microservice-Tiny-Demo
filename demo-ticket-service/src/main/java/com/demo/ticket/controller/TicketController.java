package com.demo.ticket.controller;

import com.demo.ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buyTicket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping("/feign/{id}")
    public String buyTicket(@PathVariable("id") Long id){
        System.out.println("（Feign）访问 /buyTicket/feign/"+id);
        return ticketService.buyTicket(id);
    }

    @GetMapping("/restful/{id}")
    public String buyTicketRest(@PathVariable("id") Long id){
        System.out.println("（RestTemplate） 访问 /buyTicket/restful/"+id);
        return ticketService.buyTicketRest(id);
    }

}
