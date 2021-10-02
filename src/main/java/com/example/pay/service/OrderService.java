package com.example.pay.service;

import com.example.pay.dto.OrderDTO;
import com.example.pay.entity.OrderEntity;
import com.example.pay.external.WarehouseServer;
import com.example.pay.repository.ItemDetailRepository;
import org.springframework.stereotype.Service;
import com.example.pay.repository.OrderRepository;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderService {

   private final OrderRepository orderRepository;
   private final ItemDetailRepository itemDetailRepository;
   private final WarehouseServer warehouseServer;
   private Boolean confirmation = true;

   public OrderService(OrderRepository orderRepository, ItemDetailRepository itemDetailRepository, WarehouseServer warehouseServer) {
      this.orderRepository = orderRepository;
      this.itemDetailRepository = itemDetailRepository;
      this.warehouseServer = warehouseServer;
   }

   public OrderDTO confirmPayment(OrderDTO orderDTO) {

      if (confirmation) {
         orderDTO.setStatus("PAYMENT_CONFIRMED");
      } else {
         orderDTO.setStatus("PAYMENT_REJECTED");
      }

      OrderEntity orderEntity = orderDTO.toEntity();

      confirmation = !confirmation;

      warehouseServer.confirmPayment(orderDTO);
      orderEntity.getItemDetails().forEach(itemDetailRepository::save);
      orderEntity = orderRepository.save(orderEntity);

//      if (orderDTO.getStatus().equals("PAYMENT_CONFIRMED")) {
         return orderEntity.toDTO();
//      } else {
//         throw new Exception("payment rejected");
//      }
   }
}
