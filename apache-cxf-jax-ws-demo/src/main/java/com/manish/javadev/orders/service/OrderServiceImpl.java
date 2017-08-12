package com.manish.javadev.orders.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.stereotype.Service;

import com.javadev.manish.schema.order.AccountType;
import com.javadev.manish.schema.order.BookType;
import com.javadev.manish.schema.order.ObjectFactory;
import com.javadev.manish.schema.order.OrderInquiryResponseType;
import com.javadev.manish.schema.order.OrderItemType;
import com.javadev.manish.schema.order.OrderStatusType;
import com.javadev.manish.schema.order.OrderType;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public OrderInquiryResponseType processOrder(int uniqueOrderId, int orderQuantity, int accountId, long isbn) {

		ObjectFactory objectFactory = new ObjectFactory();
		OrderInquiryResponseType response = objectFactory.createOrderInquiryResponseType();
		AccountType accountType = objectFactory.createAccountType();
		accountType.setAccountId(100);
		response.setAccount(accountType);

		OrderItemType orderItemType = objectFactory.createOrderItemType();

		BookType bookType = objectFactory.createBookType();
		bookType.setTitle("A JAVA BOOK");
		bookType.setIsbn(new Long(1234));
		orderItemType.setBook(bookType);
		try {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			cal.add(Calendar.DATE, 5);
			XMLGregorianCalendar estimatedDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
			orderItemType.setExpectedShippingDate(estimatedDate);
			orderItemType.setLineNumber(1);
			orderItemType.setPrice(new BigDecimal(200.20));
			orderItemType.setQualityShippped(orderQuantity);
		} catch (Exception e) {
			// TODO: handle exception
		}
		OrderType orderType = objectFactory.createOrderType();
		orderType.setOrderItems(orderItemType);
		orderType.setOrderStatus(OrderStatusType.READY);
		response.setOrder(orderType);

		return response;
	}

}
