package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

import javax.persistence.*;

//@IdClass(value = OrderDetailId.class)
@Entity
@Table (name = "order_detail")
public class OrderDetail  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*@Id
        @Column(name = "order_id", insert=false ,update=false )
        private Integer orderId;*/
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderDetailId;

	@Column(name = "product_id", insertable=false ,updatable=false)
	private Integer productId;
	
	@Column(name = "quantity")
	private double quantity;
	
	@Column(name = "amount")
	private double amount;

	/*@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
	private Orders orders;*/

	@OneToOne
    @JoinColumn(name="product_id")
	private Product product;

	/*public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
*/


	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Product getProduct() {return product;}

	public void setProduct(Product product) {this.product = product;}

	/*public Orders getOrders() {return orders;}

	public void setOrders(Orders orders) {this.orders = orders;}*/

	@Override
	public String toString() {
		return "OrderDetail [productId=" + productId + ", quantity=" + quantity + ", amount="
				+ amount + ", product=" + product  + "]";
		/*return "OrderDetail [orderId=" + orderId + ", productId=" + productId + ", quantity=" + quantity + ", amount="
				+ amount + ", product=" + product + ", order=" + orders + "]";*/
	}
	
}
