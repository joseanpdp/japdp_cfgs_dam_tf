package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import japdp.damtf.application.dto.request.OrderDetailRequest;
import japdp.damtf.application.dto.response.OrderDetailResponse;
import japdp.damtf.application.dto.response.OrderDetailResponseBrief;
import japdp.damtf.application.exception.CustomerNotFoundException;
import japdp.damtf.application.exception.OrderDetailNotFoundException;
import japdp.damtf.application.exception.OrderNotFoundException;
import japdp.damtf.application.exception.ProductNotFoundException;
import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;
import japdp.damtf.application.persistence.repository.OrderDetailRepository;
import japdp.damtf.application.persistence.repository.OrderRepository;
import japdp.damtf.application.persistence.repository.ProductRepository;

/**
 * La implementación de OrderDetailService proporciona métodos para gestionar los 
 * detalles de los pedidos.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<OrderDetailResponseBrief> getAll() {
		List<OrderDetail> orderDetails = orderDetailRepository.findAll();
		List<OrderDetailResponseBrief> orderDetailsDTO2 = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailDTO2 = new OrderDetailResponseBrief(orderDetail);
			orderDetailsDTO2.add(orderDetailDTO2);
		}
		return orderDetailsDTO2;
	}

	@Override
	public OrderDetailResponse getById(long id) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if (optionalOrderDetail.isPresent()) {
			OrderDetail orderDetail = optionalOrderDetail.get();
			return new OrderDetailResponse(orderDetail);
		} else {
			throw new CustomerNotFoundException(id);
		}
	}

	@Override
	public List<OrderDetailResponseBrief> getByOrderId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
		List<OrderDetailResponseBrief> orderDetailsResponseBrief = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailResponseBrief = new OrderDetailResponseBrief(orderDetail);
			orderDetailsResponseBrief.add(orderDetailResponseBrief);
		}
		return orderDetailsResponseBrief;
	}

	@Override
	public List<OrderDetailResponseBrief> getByProductId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByProductId(id);
		List<OrderDetailResponseBrief> orderDetailsResponseBrief = new ArrayList<>();
		for (OrderDetail orderDetail : orderDetails) {
			OrderDetailResponseBrief orderDetailResponseBrief = new OrderDetailResponseBrief(orderDetail);
			orderDetailsResponseBrief.add(orderDetailResponseBrief);
		}
		return orderDetailsResponseBrief;
	}

	@Override
	public OrderDetailResponse create(OrderDetailRequest orderDetailRequest) {
		long orderId = orderDetailRequest.getOrderId();
		long productId = orderDetailRequest.getProductId();
		Optional<Order> optionalOrder = orderRepository.findById(orderId);
		if (optionalOrder.isPresent()) {
			Order order = optionalOrder.get();
			Optional<Product> optionalProduct = productRepository.findById(productId);
			if (optionalProduct.isPresent()) {
				Product product = optionalProduct.get();
				OrderDetail orderDetail = new OrderDetail(order, product, orderDetailRequest.getQuantity());
				orderDetailRepository.save(orderDetail);
				return new OrderDetailResponse(orderDetail);
			} else {
				throw new ProductNotFoundException(productId);
			}
		} else {
			throw new OrderNotFoundException(orderId);
		}
	}

	@Override
	public OrderDetailResponse update(long id, OrderDetailRequest orderDetailRequest) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if (optionalOrderDetail.isPresent()) {
			OrderDetail orderDetail = optionalOrderDetail.get();
			long orderId = orderDetailRequest.getOrderId();
			Optional<Order> optionalOrder = orderRepository.findById(orderId);
			if (optionalOrder.isPresent()) {
				Order order = optionalOrder.get();
				long productId = orderDetailRequest.getProductId();
				Optional<Product> optionalProduct = productRepository.findById(productId);
				if (optionalProduct.isPresent()) {
					Product product = optionalProduct.get();
					orderDetail.setOrder(order);
					orderDetail.setProduct(product);
					orderDetail.setQuantity(orderDetailRequest.getQuantity());
					orderDetailRepository.save(orderDetail);
					return new OrderDetailResponse(orderDetail);
				} else {
					throw new ProductNotFoundException(productId);
				}
			} else {
				throw new OrderNotFoundException(orderId);
			}
		} else {
			throw new OrderDetailNotFoundException(id);
		}
	}

	@Override
	public void delete(long id) {
		Optional<OrderDetail> optionalOrderDetail = orderDetailRepository.findById(id);
		if (optionalOrderDetail.isPresent()) {
			orderDetailRepository.deleteById(optionalOrderDetail.get().getId());
		}
	}

	public void deleteByOrderId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByOrderId(id);
		for (OrderDetail orderDetail : orderDetails) {
			this.delete(orderDetail.getId());
		}
	}

	public void deleteByProductId(long id) {
		List<OrderDetail> orderDetails = orderDetailRepository.findByProductId(id);
		for (OrderDetail orderDetail : orderDetails) {
			this.delete(orderDetail.getId());
		}
	}

}
