package com.jikexueyuan.caiwen.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CATEGORY")
public class Category implements Serializable {

	private static final long serialVersionUID = 3332664472251908L;
	private Integer id;
	private String categoryName;
	
	@Id
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "CATEGORY_NAME")
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Category category = (Category) o;

		if (!id.equals(category.id)) return false;
		return categoryName.equals(category.categoryName);

	}

	@Override
	public int hashCode() {
		int result = id.hashCode();
		result = 31 * result + categoryName.hashCode();
		return result;
	}
}
