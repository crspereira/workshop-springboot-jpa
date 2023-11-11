package com.claytonpereira.springproject01.entities.enuns;

public enum OrderStatus {
	
	WAITING_PAYMENY(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	//método que recebe um valor e retorna o OrderStatus
	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;	
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus Code!");
	}
	
}
