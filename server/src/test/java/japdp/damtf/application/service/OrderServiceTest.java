package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import japdp.damtf.application.dto.response.OrderResponseBrief;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.repository.OrderRepository;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
	@InjectMocks
	OrderService service = new OrderServiceImpl();

	@Mock
	OrderRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindAllOrders() {
		Customer customer = new Customer("Jose", "Paco", "Sevilla");
		List<Order> list1 = new ArrayList<Order>();
		Order one   = new Order(customer, "05-01-2024", "Sevilla");
		Order two   = new Order(customer, "09-01-2024", "Sevilla");
		Order three = new Order(customer, "12-01-2024", "Sevilla");

		list1.add(one);
		list1.add(two);
		list1.add(three);

		Mockito.when(repository.findAll()).thenReturn(list1);

		List<OrderResponseBrief> list2 = service.getAll();

		Assertions.assertEquals(3, list2.size());
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}

}
