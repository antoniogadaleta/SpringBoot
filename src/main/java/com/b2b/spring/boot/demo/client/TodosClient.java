package com.b2b.spring.boot.demo.client;

import com.b2b.spring.boot.demo.entity.Todo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Set;

@FeignClient(url = "https://jsonplaceholder.typicode.com", name="todos")
public interface TodosClient {

    @GetMapping("/todos")
    Set<Todo> test();
}
