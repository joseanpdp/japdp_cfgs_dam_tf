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

import japdp.damtf.application.dto.response.OrderDetailResponseBrief;
import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;
import japdp.damtf.application.persistence.repository.OrderDetailRepository;

@ExtendWith(MockitoExtension.class)
public class OrderDetailServiceTest {

	@InjectMocks
	OrderDetailService service = new OrderDetailServiceImpl();

	@Mock
	OrderDetailRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindAllOrderDetails() {
		List<OrderDetail> list1 = new ArrayList<OrderDetail>();
		Category category = new Category("Comida", "Comida");
		Product product = new Product("Pan", 1.2, "Comida", category, 100);
		Customer customer = new Customer("Jose", "Juan", "Sevilla");
		Order order = new Order(customer, "01-01-2023", "Sevilla");
		OrderDetail one   = new OrderDetail(order, product, 20);
		OrderDetail two   = new OrderDetail(order, product, 100);
		OrderDetail three = new OrderDetail(order, product, 10);

		list1.add(one);
		list1.add(two);
		list1.add(three);

		Mockito.when(repository.findAll()).thenReturn(list1);

		List<OrderDetailResponseBrief> list2 = service.getAll();

		Assertions.assertEquals(3, list2.size());
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}
	
}
