package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.damtf.application.dto.request.OrderRequest;
import japdp.damtf.application.dto.response.OrderResponse;
import japdp.damtf.application.dto.response.OrderResponseBrief;
import japdp.damtf.application.exception.CustomerNotFoundException;
import japdp.damtf.application.exception.OrderNotFoundException;
import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderStatus;
import japdp.damtf.application.persistence.repository.CustomerRepository;
import japdp.damtf.application.persistence.repository.OrderRepository;

/**
 * La clase OrderServiceImpl implementa la interfaz OrderService y proporciona la lógica 
 * para gestionar los pedidos.
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailService orderDetailService;

	@Override
	public List<OrderResponseBrief> getAll() {
		List<Order> orders = orderRepository.findAll();
		List<OrderResponseBrief> ordersDTO2 = new ArrayList<>();
		for (Order order : orders) {
			OrderResponseBrief orderDTO = new OrderResponseBrief(order);
			ordersDTO2.add(orderDTO);
		}
		return ordersDTO2;
	}

	@Override
	public OrderResponse getById(long id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			return new OrderResponse(order);
		} else {
			throw new OrderNotFoundException(id);
		}
	}

	@Override
	public List<OrderResponseBrief> getByCustomerId(long id) {
		List<Order> orders = orderRepository.findByCustomerId(id);
		List<OrderResponseBrief> ordersResponseBrief = new ArrayList<>();
		for (Order order : orders) {
			OrderResponseBrief orderResponseBrief = new OrderResponseBrief(order);
			ordersResponseBrief.add(orderResponseBrief);
		}
		return ordersResponseBrief;
	}

	@Override
	public OrderResponse create(OrderRequest orderRequest) {
		long customerId = orderRequest.getCustomerId();
		Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
		if (optionalCustomer.isPresent()) {
			Customer customer = optionalCustomer.get();
			Order order = new Order(customer, orderRequest.getDate(), orderRequest.getShipAddress());
			orderRepository.save(order);
			return new OrderResponse(order);
		} else {
			throw new CustomerNotFoundException(customerId);
		}
	}

	@Override
	public OrderResponse update(long id, OrderRequest orderRequest) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			order.setDate(orderRequest.getDate());
			order.setShipAddress(orderRequest.getShipAddress());
			order.setStatus(orderRequest.getStatus());

			orderRepository.save(order);
			return new OrderResponse(order);
		} else {
			throw new OrderNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<Order> optionalOrder = orderRepository.findById(id);
		if (optionalOrder.isPresent()) {
			orderDetailService.deleteByOrderId(id);
			orderRepository.deleteById(optionalOrder.get().getId());
		}
	}

	public void deleteByCustomerId(long id) {
		List<Order> orders = orderRepository.findByCustomerId(id);
		for (Order order : orders) {
			this.delete(order.getId());
		}
	}

	@Override
	public List<OrderResponseBrief> getByStatus(OrderStatus status) {
		List<Order> orders = orderRepository.findByStatus(status);
		List<OrderResponseBrief> ordersResponseBrief = new ArrayList<>();
		for (Order order : orders) {
			OrderResponseBrief orderResponseBrief = new OrderResponseBrief(order);
			ordersResponseBrief.add(orderResponseBrief);
		}
		return ordersResponseBrief;
	}

}
