package japdp.damtf.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.damtf.application.persistence.model.OrderDetail;
import japdp.damtf.application.persistence.model.Product;

/**
 * La interfaz ProductRepository proporciona métodos para acceder y manipular datos
 * de la entidad Product en la base de datos. Utiliza Spring Data JPA para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas personalizadas.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.name=:name")
	public Optional<Product> findByName(String name);

	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.id=:id")
	public List<Product> findByCategoryId(long id);

	@Query("SELECT od FROM OrderDetail od JOIN od.product p WHERE p.id=:id")
	public List<OrderDetail> findOrderDetailsByProductId(long id);

}
