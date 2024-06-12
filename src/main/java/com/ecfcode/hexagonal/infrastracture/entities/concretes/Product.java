package com.ecfcode.hexagonal.infrastracture.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

	@Id
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private int unitsInStock;
	
	@Column(name="discontinued")
    private int discontinued; 
	
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;
}
