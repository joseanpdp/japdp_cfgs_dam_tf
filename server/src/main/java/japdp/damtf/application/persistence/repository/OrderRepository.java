package japdp.damtf.application.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.damtf.application.persistence.model.Order;
import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.OrderStatus;

/**
 * La interfaz OrderRepository proporciona métodos para acceder y manipular datos
 * de la entidad Order en la base de datos. Utiliza Spring Data JPA para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas personalizadas.
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.id=:id")
	public List<Order> findByCustomerId(long id);

	@Query("SELECT o FROM Order o WHERE o.status=:status")
	public List<Order> findByStatus(OrderStatus status);

	@Query("SELECT od FROM OrderDetail od JOIN od.order o WHERE o.id=:id")
	public List<OrderDetail> findOrderDetailsByOrderId(long id);

}
