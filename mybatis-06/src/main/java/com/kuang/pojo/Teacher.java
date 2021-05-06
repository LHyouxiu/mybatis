package com.kuang.pojo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Teacher {
    private int id;
    private String name;

    private List<Student> students;
}
