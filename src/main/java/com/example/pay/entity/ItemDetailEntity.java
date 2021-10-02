package com.example.pay.entity;

import com.example.pay.dto.ItemsDetailDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "item_detail_entity")
public class ItemDetailEntity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "item_id")
   private Long itemID;

//   @ManyToOne()
//   @JoinColumn(name="itemDetails")
//   private OrderEntity orderEntity;
   @Column(name = "order_id")
   private Long orderID;

   @Column(name = "count")
   private Integer count;

   @Column(name = "price")
   private Double price;

   public ItemsDetailDTO toDTO() {

      final ItemsDetailDTO itemsDetailDTO = new ItemsDetailDTO();
      itemsDetailDTO.setId(this.id);
      itemsDetailDTO.setItemID(this.itemID);
      itemsDetailDTO.setOrderID(this.orderID);
      itemsDetailDTO.setCount(this.count);
      itemsDetailDTO.setPrice(this.price);

      return itemsDetailDTO;
   }
}
