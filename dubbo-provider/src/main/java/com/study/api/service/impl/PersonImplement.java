package com.study.api.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.api.model.Person;
import com.study.api.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class PersonImplement implements PersonService {
    @Override
    public List<Person> getAllPerson() {
        List<Person> list = getAllPersonImpl();
        return list;
    }

    public List<Person> getAllPersonImpl(){
        List<Person> list = new ArrayList<>();
        Person person = new Person("樊斌","27","boy","原平");
        Person person2 = new Person("邱淑贞","17","girl","尖沙咀");
        list.add(person);
        list.add(person2);
        return list;
    }

}
