package com.jikexueyuan.caiwen.domain;

import com.jikexueyuan.caiwen.command.CommodityCommand;
import com.jikexueyuan.caiwen.command.VipCommand;
import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Consume implements Serializable {
    private Integer id;
    private BigDecimal practicePrice;
    private VipCommand vip;
    private CommodityCommand commodity;

    @Id
    @Column(name = "CONSUMEID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPracticePrice() {
        return practicePrice;
    }

    public void setPracticePrice(BigDecimal practicePrice) {
        this.practicePrice = practicePrice;
    }

    @Embedded
    public VipCommand getVip() {
        return vip;
    }

    public void setVip(VipCommand vip) {
        this.vip = vip;
    }

    @Embedded
    public CommodityCommand getCommodity() {
        return commodity;
    }

    public void setCommodity(CommodityCommand commodity) {
        this.commodity = commodity;
    }
}
