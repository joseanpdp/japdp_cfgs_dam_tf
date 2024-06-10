package japdp.damtf.application.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderDetailRepositoryTest {
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	
	@Test
	public void testCreateReadDelete() {
		Category category = new Category("Comida", "Comida");
		Product product = new Product("Pan", 1.2, "Comida", category, 10);
		Customer customer = new Customer("Jose", "Juan", "Sevilla");
		Order order = new Order(customer, "01-01-2023", "Sevilla");
		OrderDetail orderDetail = new OrderDetail(order, product, 2);

		orderDetailRepository.save(orderDetail);
		customerRepository.save(customer);
		productRepository.save(product);
		categoryRepository.save(category);
		orderRepository.save(order);

		Iterable<OrderDetail> orderDetails = orderDetailRepository.findAll();
		Assertions.assertThat(orderDetails).extracting(OrderDetail::getQuantity).containsOnly(2);

		orderDetailRepository.deleteAll();
		Assertions.assertThat(orderDetailRepository.findAll()).isEmpty();
	}
}
