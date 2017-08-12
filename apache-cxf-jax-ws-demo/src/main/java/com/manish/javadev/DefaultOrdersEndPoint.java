package com.manish.javadev;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javadev.manish.schema.order.OrderInquiryResponseType;
import com.javadev.manish.schema.order.OrderInquiryType;
import com.manish.javadev.orders.service.OrderService;

import javadev.manish.service.orders.Orders;

@Service
@WebService(portName = "OrdersSOAP", serviceName = "Orders", targetNamespace = "http://www.manish.javadev/service/Orders/", endpointInterface = "javadev.manish.service.orders.Orders")
public class DefaultOrdersEndPoint implements Orders {
	@Autowired
	public OrderService orderService;

	@Override
	public OrderInquiryResponseType processOrderPlacement(OrderInquiryType orderInquiry) {
		System.out.println("orderService = " + orderService);
		OrderInquiryResponseType response = orderService.processOrder(orderInquiry.getUniqueOrderId(),
				orderInquiry.getOrderQuantity(), orderInquiry.getAccountId(), orderInquiry.getIsbn());

		return response;
	}

}
