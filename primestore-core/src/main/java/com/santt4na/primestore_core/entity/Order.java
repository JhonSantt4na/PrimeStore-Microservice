package com.santt4na.primestore_core.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.santt4na.primestore_core.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;
	
	@Enumerated(EnumType.STRING)
	private OrderStatus orderStatus;
	
	private Long clientId;
	
	@OneToMany(mappedBy = "id.order")
	private Set<OrderItem> items = new HashSet<>();
	
	public Order() {
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrderItem x : items) {
			sum = sum + x.getSubTotal();
		}
		return sum;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}