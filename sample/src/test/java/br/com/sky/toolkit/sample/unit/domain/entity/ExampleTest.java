package br.com.sky.toolkit.sample.unit.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.lenient;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.time.LocalDateTime;

import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import br.com.sky.toolkit.sample.domain.entity.ExampleEntity;

import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.InternalServerErrorException;

class ExampleTest {

	private String validName = "Jose";
	private String validDescription = "ola mundo";
	private Long validId = 44L;
	private Boolean isActive = true;

	@Test
	void instantiate() {

		ExampleEntity exampleEntity = new ExampleEntity(validName, validDescription);

		assertThat(exampleEntity.getName()).isNotNull();
		assertThat(exampleEntity.getDescription()).isNotNull();

	}

	@Test
	void instantiateWhenIdIsNotNull() {

		ExampleEntity exampleEntity = new ExampleEntity(validId, validName, validDescription);

		assertThat(exampleEntity.getName()).isNotNull();
		assertThat(exampleEntity.getDescription()).isNotNull();
		assertThat(exampleEntity.getId()).isNotZero();

	}

	@Test
	void instantiateWhenActive() {

		ExampleEntity exampleEntity = new ExampleEntity(validId, validName, validDescription, isActive);

		assertThat(exampleEntity.getName()).isNotNull();
		assertThat(exampleEntity.getDescription()).isNotNull();
		assertThat(exampleEntity.getId()).isNotZero();
		assertThat(exampleEntity.getIsActive()).isTrue();

	}
	
	@Test
	@DisplayName("Should throw error due to inexistent entity")
	void should_throw_error_due_to_inexistent_entity() {
		
		ExampleEntity exampleEntity = new ExampleEntity(validId, validName, validDescription);

		BadRequestException exception = assertThrows(BadRequestException.class, () -> {
			exampleEntity.getId);
		
		});

	}

}
