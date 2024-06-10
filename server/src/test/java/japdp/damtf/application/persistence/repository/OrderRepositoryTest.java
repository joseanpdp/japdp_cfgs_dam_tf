package japdp.damtf.application.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class OrderRepositoryTest {
	@Autowired
	CustomerRepository customerRepository;
	@Autowired
	OrderRepository orderRepository;

	@Test
	public void testCreateReadDelete() {
		Customer customer = new Customer("Jose", "Juan", "Sevilla");
		Order order = new Order(customer, "01-01-2023", "Sevilla");

		customerRepository.save(customer);
		orderRepository.save(order);

		Iterable<Order> orders = orderRepository.findAll();
		Assertions.assertThat(orders).extracting(Order::getCustomer).containsOnly(customer);

		orderRepository.deleteAll();
		Assertions.assertThat(orderRepository.findAll()).isEmpty();
	}
}
