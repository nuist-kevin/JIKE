package com.jikexueyuan.caiwen.domain;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by caiwen on 2016/7/21.
 */
@Entity
public class Commodity implements Serializable{

    private Integer id;
    private String name;
    private BigDecimal price;
    private BigDecimal agio;

    @Id
    @Column(name = "COMMODITYID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    @Column(name = "commodityname")
    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getAgio() {
        return agio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAgio(BigDecimal agio) {
        this.agio = agio;
    }
}
