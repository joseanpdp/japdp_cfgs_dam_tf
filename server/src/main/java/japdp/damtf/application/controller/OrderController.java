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

import japdp.damtf.application.dto.request.OrderRequest;
import japdp.damtf.application.dto.response.OrderResponse;
import japdp.damtf.application.dto.response.OrderResponseBrief;
import japdp.damtf.application.exception.OrderNotFoundException;
import japdp.damtf.application.persistence.model.OrderStatus;
import japdp.damtf.application.service.OrderService;

/**
 * Controlador REST para la gestión de pedidos.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar pedidos.
 * Maneja la excepción lanzada cuando no se encuentra un pedido.
 */
@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

	@Autowired
	OrderService orderService;

	@ExceptionHandler(OrderNotFoundException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleOrderNotFoundException(Exception e) {
		LOGGER.info("Pedido no encontrado: {}",e.getMessage());   
		return "Pedido no encontrado: " + e;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getAll() {
		LOGGER.info("Solicitados todos los pedidos");   
		return orderService.getAll();
	}

	@GetMapping("/bycustomer/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getByCustomerId(@PathVariable long id) {
		LOGGER.info("Solicitado el pedido del cliente con id={}", id);   
		return orderService.getByCustomerId(id);
	}

	@GetMapping("/bystatus/{status}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderResponseBrief> getByStatus(@PathVariable OrderStatus status) {
		LOGGER.info("Solicitados los pedidos con estado: {}", status);   
		return orderService.getByStatus(status);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderResponse getById(@PathVariable long id) {
		LOGGER.info("Solicitado el pedido con id={}", id);   
		return orderService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderResponse create(@RequestBody OrderRequest orderRequest) {
		LOGGER.info("Solicitada la creación de un pedido del cliente con id={}", orderRequest.getCustomerId());   
		return orderService.create(orderRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderResponse update(@PathVariable long id, @RequestBody OrderRequest orderRequest) {
		LOGGER.info("Solicitada la actualización del pedido con id={}", id);   
		return orderService.update(id, orderRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void delete(@PathVariable long id) {
		LOGGER.info("Solicitada la eliminación del pedido con id={}", id);   
		orderService.delete(id);
	}

}
