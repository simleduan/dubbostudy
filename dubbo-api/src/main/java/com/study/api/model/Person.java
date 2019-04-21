package com.study.api.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(value = "我是人啊", description = "我是人啊")
public class Person implements Serializable {
    @ApiModelProperty(value = "姓名", example = "邱淑贞")
    private String name;
    @ApiModelProperty(value = "年龄", example = "18")
    private String age;
    @ApiModelProperty(value = "性别", example = "女")
    private String gender;
    @ApiModelProperty(value = "家乡", example = "尖沙咀")
    private String hometown;

    public Person(String name, String age, String gender, String hometown) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.hometown = hometown;
    }
}
