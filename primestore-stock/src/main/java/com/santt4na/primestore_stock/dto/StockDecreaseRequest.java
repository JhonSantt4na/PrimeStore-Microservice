package com.santt4na.primestore_stock.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StockDecreaseRequest {
	
	private List<ItemRequest> items;
	
	@Getter @Setter @NoArgsConstructor @AllArgsConstructor
	public static class ItemRequest {
		private Long productId;
		private Integer quantity;
	}
}