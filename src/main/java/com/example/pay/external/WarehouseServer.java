package com.example.pay.external;

import com.example.pay.dto.OrderDTO;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class WarehouseServer {
   private final WebClient webClient = WebClient.create("https://ptsv2.com/t/pesy1-1633173377/post");

   public Boolean confirmPayment(OrderDTO orderDTO) {

      final String block = webClient.post()
              .contentType(MediaType.APPLICATION_JSON)
//              .body(BodyInserters.fromPublisher(Mono.just(orderDTO), OrderDTO.class))
              .retrieve()
              .bodyToMono(String.class).block();

      System.out.println("block = " + block);
      return true;
   }
}
