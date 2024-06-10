package japdp.damtf.application.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import japdp.damtf.application.dto.response.ProductResponse;
import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.model.Product;
import japdp.damtf.application.persistence.repository.ProductRepository;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
	@InjectMocks
	ProductService service = new ProductServiceImpl();

	@Mock
	ProductRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	void testFindAllProducts() {
		Category category = new Category("Comida", "Comida");
		List<Product> list1 = new ArrayList<Product>();
		Product one   = new Product("Pan", 10, "Comida", category, 10);
		Product two   = new Product("Queso", 15, "Comida", category, 20);
		Product three = new Product("Jamón", 20, "Comida", category, 40);

		list1.add(one);
		list1.add(two);
		list1.add(three);

		Mockito.when(repository.findAll()).thenReturn(list1);

		List<ProductResponse> list2 = service.getAll();

		Assertions.assertEquals(3, list2.size());
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}
}
