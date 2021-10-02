package com.example.pay.controller;

import com.example.pay.dto.OrderDTO;
import com.example.pay.external.WarehouseServer;
import com.example.pay.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

   private final OrderService orderService;

   public BasicController(OrderService orderService) {
      this.orderService = orderService;
   }

   @PostMapping("/test")
   public ResponseEntity<OrderDTO> testPost(@RequestBody OrderDTO orderDTO) {
//      try {
         return ResponseEntity.ok(orderService.confirmPayment(orderDTO));
//      } catch (Exception e) {
//         return ResponseEntity.badRequest().body(e.getMessage());
//      }
   }
}
