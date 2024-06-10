package japdp.damtf.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.damtf.application.persistence.model.Customer;
import japdp.damtf.application.persistence.model.Order;

/**
 * La interfaz CustomerRepository proporciona métodos para acceder y manipular datos
 * de la entidad Customer en la base de datos. Utiliza Spring Data JPA para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas personalizadas.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE c.name=:name AND c.surname=:surname")
	public Optional<Customer> findByNameAndSurname(String name, String surname);

	@Query("SELECT o FROM Order o JOIN o.customer c WHERE c.id=:id")
	public List<Order> findOrdersByCustomerId(long id);
}
