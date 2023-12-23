package com.example.webapp.firstWebApp.service;

import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.webapp.firstWebApp.repository.EntityRepository;
import com.okta.commons.lang.Assert;
import com.example.webapp.firstWebApp.entity.*;
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {
	
	@Mock
	private EntityRepository entityRepository;
	
	@InjectMocks
	private TodoService todoService;
	
	@Test
	private void findByUsernameTest() {
		// TODO Auto-generated method stub
		int id = 10001;
		Todo todo =  new Todo(10001,"Ganesh Krishnan Balasubramanian", "Get AWS Certified",LocalDate.now() ,false);
		when(entityRepository.findById(id)).thenReturn(java.util.Optional.of(todo));
		Todo findByID = todoService.findByID(id);
		Assertions.assertEquals(todo, findByID);
	}

}
