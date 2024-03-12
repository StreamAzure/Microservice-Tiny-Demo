#!/bin/bash

while true; do
    curl http://localhost:8082/buyTicket/restful/1
    sleep 1
    curl http://localhost:8082/buyTicket/feign/1
done
