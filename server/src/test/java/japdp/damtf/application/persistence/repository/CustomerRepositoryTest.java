package japdp.damtf.application.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Customer;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTest {
	
	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void testCreateReadDelete() {
		Customer customer = new Customer("Jose", "Juan", "Cádiz");

		customerRepository.save(customer);

		Iterable<Customer> customers = customerRepository.findAll();
		Assertions.assertThat(customers).extracting(Customer::getName).containsOnly("Jose");

		customerRepository.deleteAll();
		Assertions.assertThat(customerRepository.findAll()).isEmpty();
	}

}
