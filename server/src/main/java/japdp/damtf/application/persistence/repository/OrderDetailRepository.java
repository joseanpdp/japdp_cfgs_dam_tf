package japdp.damtf.application.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.damtf.application.persistence.model.OrderDetail;

/**
 * La interfaz OrderDetailRepository proporciona métodos para acceder y manipular datos
 * de la entidad OrderDetail en la base de datos. Utiliza Spring Data JPA para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas personalizadas.
 */
@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

	@Query("SELECT od FROM OrderDetail od JOIN od.order o WHERE o.id=:id")
	public List<OrderDetail> findByOrderId(long id);

	@Query("SELECT od FROM OrderDetail od JOIN od.product p WHERE p.id=:id")
	public List<OrderDetail> findByProductId(long id);
}
