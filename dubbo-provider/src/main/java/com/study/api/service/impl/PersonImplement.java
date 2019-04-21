package com.study.api.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.api.model.Person;
import com.study.api.service.PersonService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class PersonImplement implements PersonService,InitializingBean {
    @Override
    public List<Person> getAllPerson() {
        List<Person> list = getAllPersonImpl();
        return list;
    }

    @Override
    public String sayHello(String name) {
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + name
                + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return "Hello " + name + ", response form provider: " + RpcContext.getContext().getLocalAddress();
    }

    public List<Person> getAllPersonImpl(){
        List<Person> list = new ArrayList<>();
        Person person = new Person("樊斌","27","boy","原平");
        Person person2 = new Person("邱淑贞","17","girl","尖沙咀");
        list.add(person);
        list.add(person2);
        return list;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("***********************************");
    }
}
