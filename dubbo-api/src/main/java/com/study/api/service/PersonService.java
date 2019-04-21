package com.study.api.service;

import com.study.api.model.Person;

import java.util.List;

/**
 * 对外提供的接口
 */
public interface PersonService {

   List<Person> getAllPerson();

   String sayHello(String name);
}
