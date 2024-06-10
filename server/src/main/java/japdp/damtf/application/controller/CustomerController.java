package japdp.damtf.application.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import japdp.damtf.application.dto.request.CustomerRequest;
import japdp.damtf.application.dto.response.CustomerResponse;
import japdp.damtf.application.exception.CustomerNotFoundException;
import japdp.damtf.application.service.CustomerService;

/**
 * Controlador REST para la gestión de clientes.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar clientes.
 * Maneja la excepción lanzada cuando no se encuentra un cliente.
 */
@CrossOrigin
@RestController
@RequestMapping("/customer")
public class CustomerController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	
	@Autowired
	CustomerService customerService;

	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleCustomerNotFoundException(Exception e) {
		LOGGER.info("Cliente no encontrado: {}",e.getMessage());   
		return "Cliente no encontrado: " + e;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerResponse> getAll() {
		LOGGER.info("Solicitados todos los clientes");   
		return customerService.getAll();
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse getById(@PathVariable long id) {
		LOGGER.info("Solicitado el cliente con id={}", id);   
		return customerService.getById(id);
	}

	@GetMapping("/{name}/{surname}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse getCustomerByNameAndSurname(@PathVariable String name, @PathVariable String surname) {
		LOGGER.info("Solicitado el cliente {}-{}", name, surname);   
		return customerService.getByNameAndSurname(name, surname);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse createCustomer(@RequestBody CustomerRequest customerRequest) {
		LOGGER.info("Solicitada la creación del cliente {}-{}", customerRequest.getName(), customerRequest.getSurname());   
		return customerService.create(customerRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public CustomerResponse updateCustomer(@PathVariable long id, @RequestBody CustomerRequest customerRequest) {
		LOGGER.info("Solicitada la actualización del cliente con id={}", id);   
		return customerService.update(id, customerRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomer(@PathVariable long id) {
		LOGGER.info("Solicitada la eliminación del cliente con id={}", id);   
		customerService.delete(id);
	}

}
