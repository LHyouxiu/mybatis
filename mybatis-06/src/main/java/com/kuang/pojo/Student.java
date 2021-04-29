package com.kuang.pojo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Student {
    private int id;
    private String name;
    private int tid;

    private Teacher teacher;
}
