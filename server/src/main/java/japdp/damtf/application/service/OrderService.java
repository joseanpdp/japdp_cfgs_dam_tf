package japdp.damtf.application.service;

import java.util.List;

import japdp.damtf.application.dto.request.OrderRequest;
import japdp.damtf.application.dto.response.OrderResponse;
import japdp.damtf.application.dto.response.OrderResponseBrief;
import japdp.damtf.application.persistence.model.OrderStatus;

/**
 * La interfaz OrderService define métodos para gestionar pedidos, incluida la 
 * obtención de todos los pedidos, la obtención de pedidos por identificador de cliente, 
 * por estado, o por identificador, la creación, actualización y eliminación de pedidos, 
 * así como la eliminación de todos los pedidos asociados a un cliente específico.
 */
public interface OrderService {

	public List<OrderResponseBrief> getAll();

	public List<OrderResponseBrief> getByCustomerId(long id);

	public List<OrderResponseBrief> getByStatus(OrderStatus status);

	public OrderResponse getById(long id);

	public OrderResponse create(OrderRequest orderRequest);

	public OrderResponse update(long id, OrderRequest orderRequest);

	public void delete(long id);

	public void deleteByCustomerId(long id);

}
