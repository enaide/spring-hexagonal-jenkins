package com.ecfcode.hexagonal.infrastructure.entities.concretes;

import com.ecfcode.hexagonal.domain.models.ProductDO;
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
	private Long productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="unit_price")
	private double unitPrice;
	
	@Column(name="units_in_stock")
	private int unitsInStock;

	@Column(name="units_on_order")
	private int unitsOnOrder;

	@Column(name="quantity_per_unit")
	private String quantityPerUnit ;
	
	@Column(name="discontinued")
    private int discontinued; 
	
	@ManyToOne
	@JoinColumn(name="category_id",
			nullable = false,
			referencedColumnName = "category_id",
			foreignKey = @ForeignKey(
					name = "category_id_fk"
			))
	private Category category;


	@ManyToOne
	@JoinColumn(name="supplier_id",
			nullable = false,
			referencedColumnName = "supplier_id",
			foreignKey = @ForeignKey(
					name = "supplier_id_fk"
			))
	private Supplier supplier;

	@OneToMany(mappedBy="product")
	private List<OrderDetail> orderDetails;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;

	public Product(final ProductDO product) {
		this.productId = product.getProductId();

		this.productName = product.getProductName();
		this.unitPrice = product.getUnitPrice();
		this.unitsInStock = product.getUnitsInStock();
		this.discontinued = product.getDiscontinued();
		this.quantityPerUnit  = product.getQuantityPerUnit();
		this.unitsOnOrder = product.getUnitsOnOrder();
	}
}
