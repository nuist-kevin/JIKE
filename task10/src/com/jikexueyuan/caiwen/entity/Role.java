package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by caiwen on 2016/8/12.
 */
@Entity
public class Role implements Serializable {

    private static final long serialVersionUID = 11112L;
    private Integer id;
    private String roleName;
    public static final Integer ADMIN = 1;
    public static final Integer NORMAL = 2;
    @Id
    @Column(name = "ROLE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

//    @Override
//    public String toString() {
//        return "Role{" +
//                "id=" + id +
//                ", roleName='" + roleName + '\'' +
//                '}';
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Role role = (Role) o;
//
//        if (!id.equals(role.id)) return false;
//        return roleName.equals(role.roleName);
//
//    }

/*
    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + roleName.hashCode();
        return result;
    }
*/
}
