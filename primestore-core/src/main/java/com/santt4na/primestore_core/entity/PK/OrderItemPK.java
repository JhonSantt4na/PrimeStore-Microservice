package com.santt4na.primestore_core.entity.PK;

import com.santt4na.primestore_core.entity.Order;
import com.santt4na.primestore_core.entity.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class OrderItemPK implements Serializable {
	
	@Serial
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private Product product;
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		OrderItemPK that = (OrderItemPK) o;
		return Objects.equals(order, that.order) && Objects.equals(product, that.product);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}
}
