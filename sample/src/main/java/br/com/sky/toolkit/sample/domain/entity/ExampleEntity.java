package br.com.sky.toolkit.sample.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ExampleEntity {
	
	private Long id;
	private String name;
	private String description;

	private Boolean isActive;
	private Date createdAt;
	
	
	
	public ExampleEntity(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	public ExampleEntity(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public ExampleEntity(Long id, String name, String description, Boolean isActive) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.isActive = isActive;

	}
	
	
	

}
