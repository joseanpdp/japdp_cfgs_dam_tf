package japdp.damtf.application.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Product;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

	@Autowired
	ProductRepository productRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void testCreateReadDelete() {
		Category category = new Category("Comida", "Comida");
		Product product = new Product("Pan", 1.2, "Comida", category, 10);

		categoryRepository.save(category);
		productRepository.save(product);

		Iterable<Product> products = productRepository.findAll();
		Assertions.assertThat(products).extracting(Product::getName).containsOnly("Pan");

		productRepository.deleteAll();
		Assertions.assertThat(productRepository.findAll()).isEmpty();
	}
	
}
