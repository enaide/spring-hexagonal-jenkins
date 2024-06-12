package com.ecfcode.hexagonal.infrastracture.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="suppliers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Supplier {
	
	@Id
	
	@Column(name="supplier_id")
	private int supplierId;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="contact_name")
	private String contactName;
	
	@Column(name="contact_title")
	private String contactTitle;
	
	
	@Column(name="address")
	private String address;
	
	@OneToMany(mappedBy="supplier")
	private List<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "country_id")
	private Country country;

}
