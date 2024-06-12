package com.ecfcode.hexagonal.infrastracture.abstracts;


import com.ecfcode.hexagonal.infrastracture.entities.concretes.OrderDetail;
import com.ecfcode.hexagonal.infrastracture.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

	OrderDetail getByOrder_OrderIdAndProduct_ProductId( int orderId,int productId);
	
	OrderDetail getByProduct_ProductId( int productId);
	
	
	@Transactional
	@Modifying  
	@Query("Delete From OrderDetail  Where order_id =:orderId and product_id =:productId")
	void deleteOrderDetailWithOrderIdAndProductId( @Param("orderId")int orderId,@Param("productId")int productId);
}
