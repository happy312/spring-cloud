package com.niuniu.provider.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private String id;

    private String name;

}