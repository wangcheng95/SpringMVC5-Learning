package com.waston.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String uname;
    private Integer age;
}
