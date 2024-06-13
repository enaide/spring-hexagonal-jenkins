package com.ecfcode.hexagonal.infrastructure.abstracts;


import com.ecfcode.hexagonal.infrastructure.entities.concretes.OrderDetail;
import com.ecfcode.hexagonal.infrastructure.entities.concretes.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {

	OrderDetail getByOrder_OrderIdAndProduct_ProductId( Long orderId,int productId);
	
	OrderDetail getByProduct_ProductId( int productId);
	
	
/*	@Transactional
	@Modifying  
	@Query("Delete From OrderDetail  Where order_id =:orderId and product_id =:productId")
	void deleteOrderDetailWithOrderIdAndProductId( @Param("orderId")Long orderId,@Param("productId")int productId);*/
}
