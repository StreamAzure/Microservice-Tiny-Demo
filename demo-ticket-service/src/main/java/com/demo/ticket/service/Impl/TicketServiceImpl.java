package com.demo.ticket.service.Impl;

import com.demo.ticket.pojo.Ticket;
import com.demo.ticket.service.TicketService;
import com.stream.apis.user.IUserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketServiceImpl implements TicketService {
    @Autowired
    private IUserClient userClient;
    @Autowired
    private RestTemplate restTemplate;

    private void print(){
        System.out.println("HelloWorld");
    }

    public int plus(int a, int b){
        return a + b;
    }

    @Override
    public String buyTicket(Long id) {
        String userInfo = userClient.queryUserInfo(id);
        Ticket ticket = new Ticket(userInfo, "上海");
        return ticket.toString();
    }

    @Override
    public String buyTicketRest(Long id) {
        print();
        int c = plus(1,3);
        String url = "http://user-service:8081/getUserInfoRest/" + id;
        String userInfo = restTemplate.getForObject(url, String.class);
        Ticket ticket = new Ticket(userInfo, "北京");
        return ticket.toString();
    }
}
