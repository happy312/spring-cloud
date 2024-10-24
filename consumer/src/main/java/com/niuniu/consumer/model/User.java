package com.niuniu.consumer.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;

    private String name;

}
