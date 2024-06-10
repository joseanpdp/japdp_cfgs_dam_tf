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

import japdp.damtf.application.dto.response.CustomerResponse;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.repository.CustomerRepository;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
	@InjectMocks
	CustomerService service = new CustomerServiceImpl();

	@Mock
	CustomerRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindAllCustomers() {
		List<Customer> list1 = new ArrayList<Customer>();
		Customer one   = new Customer("Paco", "Juan", "Sevilla");
		Customer two   = new Customer("Jose", "Alejandro", "Cadiz");
		Customer three = new Customer("Pepe", "Felipe", "Madrid");

		list1.add(one);
		list1.add(two);
		list1.add(three);

		Mockito.when(repository.findAll()).thenReturn(list1);

		List<CustomerResponse> list2 = service.getAll();

		Assertions.assertEquals(3, list2.size());
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}
}
