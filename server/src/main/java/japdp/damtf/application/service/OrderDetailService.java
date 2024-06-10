package japdp.damtf.application.service;

import java.util.List;

import japdp.damtf.application.dto.request.OrderDetailRequest;
import japdp.damtf.application.dto.response.OrderDetailResponse;
import japdp.damtf.application.dto.response.OrderDetailResponseBrief;

/**
 * La interfaz OrderDetailService declara métodos para realizar operaciones relacionadas
 * con los detalles de los pedidos, como obtener todos los detalles de los pedidos, 
 * obtener detalles de pedidos por su identificador de pedido o identificador de producto, 
 * obtener un detalle de pedido por su identificador, crear, actualizar y eliminar un detalle
 * de pedido, así como eliminar todos los detalles de pedidos asociados a un pedido o producto
 * específico.
 */
public interface OrderDetailService {

	public List<OrderDetailResponseBrief> getAll();

	public List<OrderDetailResponseBrief> getByOrderId(long id);

	public List<OrderDetailResponseBrief> getByProductId(long id);

	public OrderDetailResponse getById(long id);

	public OrderDetailResponse create(OrderDetailRequest orderDetailRequest);

	public OrderDetailResponse update(long id, OrderDetailRequest orderDetail);

	public void delete(long id);

	public void deleteByOrderId(long id);

	public void deleteByProductId(long id);

}
