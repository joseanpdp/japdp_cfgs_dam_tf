package japdp.damtf.application.persistence.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import japdp.damtf.application.persistence.model.Category;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CategoryRepositoryTest {

	@Autowired
	CategoryRepository categoryRepository;

	@Test
	public void testCreateReadDelete() {
		Category category = new Category("Mi categoría", "Descripción de mi categoría");

		categoryRepository.save(category);

		Iterable<Category> categorys = categoryRepository.findAll();
		Assertions.assertThat(categorys).extracting(Category::getName).containsOnly("Mi categoría");

		categoryRepository.deleteAll();
		Assertions.assertThat(categoryRepository.findAll()).isEmpty();
	}
}
