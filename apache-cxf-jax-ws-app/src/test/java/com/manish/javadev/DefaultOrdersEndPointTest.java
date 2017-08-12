package com.manish.javadev;

import static org.junit.Assert.*;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javadev.manish.schema.order.ObjectFactory;
import com.javadev.manish.schema.order.OrderInquiryResponseType;
import com.javadev.manish.schema.order.OrderInquiryType;

import javadev.manish.service.orders.Orders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:test-beans.xml")
public class DefaultOrdersEndPointTest {

	private Orders orderService;
	private OrderInquiryType orderInquiryType;
	@Autowired
	private JaxWsProxyFactoryBean testOrderClient;

	@Before
	public void setUp() throws Exception {
		orderService = testOrderClient.create(Orders.class);
		ObjectFactory factory = new ObjectFactory();
		orderInquiryType = factory.createOrderInquiryType();
		orderInquiryType.setAccountId(100);
		orderInquiryType.setIsbn(12344);
		orderInquiryType.setOrderQuantity(100);
		orderInquiryType.setUniqueOrderId(121);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testProcessOrderPlacementSuccess() {
		OrderInquiryResponseType response = orderService.processOrderPlacement(orderInquiryType);
		assertEquals(response.getAccount().getAccountId(), 100);
	}
}
