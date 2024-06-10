package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.damtf.application.dto.request.CustomerRequest;
import japdp.damtf.application.dto.response.CustomerResponse;
import japdp.damtf.application.exception.CustomerNotFoundException;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.repository.CustomerRepository;

/**
 * La clase CustomerServiceImpl implementa la interfaz CustomerService y proporciona
 * la lógica de negocio para realizar operaciones relacionadas con los clientes.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderService orderService;

	@Override
	public List<CustomerResponse> getAll() {
		List<Customer> customers = customerRepository.findAll();
		List<CustomerResponse> customersDTO = new ArrayList<>();
		for (Customer customer : customers) {
			CustomerResponse customerDTO = new CustomerResponse(customer.getId(), customer.getName(),
					customer.getSurname(), customer.getAddress());
			customersDTO.add(customerDTO);
		}
		return customersDTO;
	}

	@Override
	public CustomerResponse getById(long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(),
					customer.getAddress());
		} else {
			throw new CustomerNotFoundException(id);
		}
	}

	@Override
	public CustomerResponse getByNameAndSurname(String name, String surname) {
		Optional<Customer> optionalCustomer = customerRepository.findByNameAndSurname(name, surname);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			return new CustomerResponse(customer.getId(), customer.getName(), customer.getSurname(),
					customer.getAddress());
		} else {
			throw new CustomerNotFoundException(name, surname);
		}
	}

	@Override
	public CustomerResponse create(CustomerRequest customerRequest) {
		Customer customer = new Customer(customerRequest.getName(), customerRequest.getSurname(),
				customerRequest.getAddress());
		customerRepository.save(customer);
		return new CustomerResponse(customer);
	}

	@Override
	public CustomerResponse update(long id, CustomerRequest customerRequest) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			customer.setName(customerRequest.getName());
			customer.setSurname(customerRequest.getSurname());
			customer.setAddress(customerRequest.getAddress());
			customerRepository.save(customer);
			return new CustomerResponse(customer);
		} else {
			throw new CustomerNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		if (optionalCustomer.isPresent()) {
			orderService.deleteByCustomerId(id);
			customerRepository.deleteById(optionalCustomer.get().getId());
		}
	}

}
