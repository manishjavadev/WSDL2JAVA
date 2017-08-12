package com.manish.javadev.orders.service;

import com.javadev.manish.schema.order.OrderInquiryResponseType;

public interface OrderService {
	OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long isbn);
}
