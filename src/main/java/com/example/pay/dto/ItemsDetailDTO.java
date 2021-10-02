package com.example.pay.dto;

import com.example.pay.entity.ItemDetailEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ItemsDetailDTO {
   private Long id;
   private Long itemID;
   private Long orderID;
   private Integer count;
   private Double price;


   public ItemDetailEntity toEntity() {
      final ItemDetailEntity itemDetailEntity = new ItemDetailEntity();
      itemDetailEntity.setId(this.id);
      itemDetailEntity.setItemID(this.itemID);
      itemDetailEntity.setOrderID(orderID);
      itemDetailEntity.setCount(this.count);
      itemDetailEntity.setPrice(this.price);

      return itemDetailEntity;
   }

}
