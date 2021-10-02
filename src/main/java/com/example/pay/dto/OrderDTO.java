package com.example.pay.dto;

import com.example.pay.entity.OrderEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {


   private Long id;
   private List<ItemsDetailDTO> items;
   private String status;

   public OrderEntity toEntity() {
      final OrderEntity orderEntity = new OrderEntity();
      orderEntity.setId(this.id);
      orderEntity.setItemDetails(this.items.stream().map(ItemsDetailDTO::toEntity).collect(Collectors.toList()));
      orderEntity.setStatus(this.status);

      return orderEntity;
   }
}
