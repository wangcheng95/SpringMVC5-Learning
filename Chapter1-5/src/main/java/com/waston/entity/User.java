package com.waston.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {
    private String name;
    private Integer age;
    private Date date;
}
