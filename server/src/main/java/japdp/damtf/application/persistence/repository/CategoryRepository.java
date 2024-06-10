package japdp.damtf.application.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Product;

/**
 * La interfaz CategoryRepository proporciona métodos para acceder y manipular datos
 * de la entidad Category en la base de datos. Utiliza Spring Data JPA para realizar
 * operaciones CRUD (Crear, Leer, Actualizar, Eliminar) y consultas personalizadas.
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("SELECT c FROM Category c WHERE c.name=:name")
	public Optional<Category> findByName(String name);

	@Query("SELECT p FROM Product p JOIN p.category c WHERE c.id=:id")
	public List<Product> findProductsByCategoryId(long id);
}
