package com.example.pay.entity;

import com.example.pay.dto.ItemsDetailDTO;
import com.example.pay.dto.OrderDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class OrderEntity {

   @Id
   private Long id;

   @OneToMany(targetEntity=ItemDetailEntity.class, mappedBy="orderID",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
   private List<ItemDetailEntity> itemDetails;

   @Column(name = "status")
   private String status;

   public OrderDTO toDTO() {
      final OrderDTO orderDTO = new OrderDTO();
      orderDTO.setId(this.id);
      orderDTO.setItems(itemDetails.stream().map(ItemDetailEntity::toDTO).collect(Collectors.toList()));
      orderDTO.setStatus(this.status);
      return orderDTO;
   }
}
