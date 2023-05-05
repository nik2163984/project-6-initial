package com.example.dictionary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DictionaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(DictionaryApplication.class, args);
        /*ConfigurableApplicationContext cxt = SpringApplication.run(DictionaryApplication.class, args);
        String[] beans = cxt.getBeanDefinitionNames();
        AtomicInteger counter = new AtomicInteger(1);
        Arrays.stream(beans)
                .sorted()
                .map(name -> counter.getAndIncrement() + ": " + name)
                .forEach(System.out::println);*/
    }

}
