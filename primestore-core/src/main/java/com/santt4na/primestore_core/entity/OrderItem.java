package com.santt4na.primestore_core.entity;

import com.santt4na.primestore_core.entity.PK.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tb_orderItem")
public class OrderItem implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private OrderItemPK id =  new OrderItemPK();
	
	private Long productId;
	
	private Integer quantity;
	
	private Double price;
	
	public OrderItem() {
	}
	
	public Double getSubTotal() {
		return price * quantity;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		OrderItem orderItem = (OrderItem) o;
		return Objects.equals(id, orderItem.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}
