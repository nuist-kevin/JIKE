package com.jikexueyuan.caiwen.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by caiwen on 2016/7/21.
 */
@Entity
public class Consume implements Serializable {
    private Integer id;
    private BigDecimal practicePrice;
    private Vip vip;
    private Commodity commodity;

    @Id
    @Column(name = "CONSUMEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public BigDecimal getPracticePrice() {
        return practicePrice;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="VIPID", referencedColumnName = "VIPID"),
            @JoinColumn(name="NAME",referencedColumnName = "NAME")
    })
    public Vip getVip() {
        return vip;
    }

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="COMMODITYID",referencedColumnName = "COMMODITYID"),
            @JoinColumn(name="COMMODITYNAME",referencedColumnName = "COMMODITYNAME"),
            @JoinColumn(name= "PRICE",referencedColumnName = "PRICE")
    })
    public Commodity getCommodity() {
        return commodity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPracticePrice(BigDecimal practicePrice) {
        this.practicePrice = practicePrice;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }
}
