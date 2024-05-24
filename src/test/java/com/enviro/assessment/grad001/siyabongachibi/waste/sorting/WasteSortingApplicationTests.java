package com.enviro.assessment.grad001.siyabongachibi.waste.sorting;

import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.exception.ResourceNotFoundException;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.model.WasteCategory;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.siyabongachibi.waste.sorting.service.WasteCategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class WasteSortingApplicationTests {

	@Mock
	private WasteCategoryRepository wasteCategoryRepository;

	@InjectMocks
	private WasteCategoryService wasteCategoryService;

	@Test
	public void findById_WasteCategoryExists_ReturnsWasteCategory() {
		WasteCategory wasteCategory = new WasteCategory();
		wasteCategory.setId(1L);
		when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.of(wasteCategory));

		WasteCategory found = wasteCategoryService.findById(1L);
		assertEquals(1L, found.getId());
	}

	@Test
	public void findById_WasteCategoryDoesNotExist_ThrowsException() {
		when(wasteCategoryRepository.findById(1L)).thenReturn(Optional.empty());

		assertThrows(ResourceNotFoundException.class, () -> {
			wasteCategoryService.findById(1L);
		});
	}

}
