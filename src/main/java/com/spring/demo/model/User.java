/*
 * @Copyright: 2005-2018 www.2345.com. All rights reserved.
 */
package com.spring.demo.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chentl
 * @version User, v0.1 2018/11/15 16:18
 */
@Data
@Document
public class User implements Serializable {
    private static final long serialVersionUID = -249378461549500238L;
    @Id
    private String id;      // 注解属性id为ID
    @Indexed(unique = true) // 注解属性username为索引，并且不能重复
    private String username;
    private String name;
    private String phone;
    private Date birthday;
}
