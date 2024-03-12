package com.demo.ticket.service.Impl;

import com.demo.ticket.pojo.Ticket;
import com.demo.ticket.service.TicketService;
import com.stream.apis.user.IUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private IUserClient userClient;
    @Override
    public String buyTicket(Long id) {
        String userInfo = userClient.queryUserInfo(id);
        Ticket ticket = new Ticket(userInfo, "上海");
        return ticket.toString();
    }
}
