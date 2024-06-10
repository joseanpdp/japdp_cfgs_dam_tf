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

import japdp.damtf.application.dto.request.OrderDetailRequest;
import japdp.damtf.application.dto.response.OrderDetailResponse;
import japdp.damtf.application.dto.response.OrderDetailResponseBrief;
import japdp.damtf.application.exception.ProductNotFoundException;
import japdp.damtf.application.service.OrderDetailService;

/**
 * Controlador REST para la gestión de detalles de pedido.
 * Proporciona endpoints para obtener, crear, actualizar y eliminar detalles de pedido.
 * Maneja la excepción lanzada cuando no se encuentra un producto asociado al detalle de pedido.
 */
@CrossOrigin
@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailController.class);

	@Autowired
	OrderDetailService orderDetailService;

	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public String handleOrderDetailNotFoundException(Exception e) {
		LOGGER.info("Detalle de pedido no encontrado: {}", e.getMessage());
		return "Detalle de pedido no encontrado: " + e;
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDetailResponseBrief> getAll() {
		LOGGER.info("Solicitados todos los detalles de pedido");
		return orderDetailService.getAll();
	}

	@GetMapping("/byorder/{id}")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDetailResponseBrief> getByOrderId(@PathVariable long id) {
		LOGGER.info("Solicitado los detalles del pedido con id={}", id);
		return orderDetailService.getByOrderId(id);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetailResponse getById(@PathVariable long id) {
		LOGGER.info("Solicitado el detalle de pedido con id={}", id);
		return orderDetailService.getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public OrderDetailResponse create(@RequestBody OrderDetailRequest orderDetailRequest) {
		LOGGER.info("Solicitada la creación de un detalle del pedido con id={}", orderDetailRequest.getOrderId());
		return orderDetailService.create(orderDetailRequest);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public OrderDetailResponse updateOrderDetail(@PathVariable long id,
			@RequestBody OrderDetailRequest orderDetailRequest) {
		LOGGER.info("Solicitada la actualización del detalle de pedido con id={}", id);
		return orderDetailService.update(id, orderDetailRequest);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteOrderDetail(@PathVariable long id) {
		LOGGER.info("Solicitada la eliminación del detalle de pedido con id={}", id);   
		orderDetailService.delete(id);
	}

}
