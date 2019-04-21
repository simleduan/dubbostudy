package com.study.api.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.api.model.Person;
import com.study.api.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(value = "PersonController", description = "第一次测试")
public class PersonController {
    @Reference
    private PersonService personService;

    @RequestMapping("/getAllPerson")
    @ApiOperation(value = "未走数据库查看",notes = "未走数据库查看",httpMethod = "GET")
    public List<Person> getAllPerson(){
        List<Person> allPerson = personService.getAllPerson();
        return allPerson;
    }
}
