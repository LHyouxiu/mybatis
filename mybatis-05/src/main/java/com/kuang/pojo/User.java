package com.kuang.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {
    private int id;
    private String name;
    private String password;

}
