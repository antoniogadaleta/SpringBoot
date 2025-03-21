package com.b2b.spring.boot.demo;

import com.b2b.spring.boot.demo.client.TodosClient;
import com.b2b.spring.boot.demo.entity.Todo;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.SecondaryTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Set;

@EnableFeignClients
@SpringBootApplication
public class Application {

  @Autowired
  private TodosClient todoClient;

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

//  @PostConstruct
//  public void todos() {
//    Set<Todo> todos = todoClient.test();
//    todos.forEach(System.out::println);
//
  }

}
