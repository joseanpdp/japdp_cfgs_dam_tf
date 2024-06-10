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

import japdp.damtf.application.dto.response.CategoryResponse;
import japdp.damtf.application.persistence.model.Category;
import japdp.damtf.application.persistence.repository.CategoryRepository;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {
	
	@InjectMocks
	CategoryService service = new CategoryServiceImpl();

	@Mock
	CategoryRepository repository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testFindAllCategories() {
		List<Category> list1 = new ArrayList<Category>();
		Category one   = new Category("Cat1", "Miau1");
		Category two   = new Category("Cat2", "Miau2");
		Category three = new Category("Cat3", "Miau3");

		list1.add(one);
		list1.add(two);
		list1.add(three);

		Mockito.when(repository.findAll()).thenReturn(list1);

		List<CategoryResponse> list2 = service.getAll();

		Assertions.assertEquals(3, list2.size());
		Mockito.verify(repository, Mockito.times(1)).findAll();
	}
	
}
