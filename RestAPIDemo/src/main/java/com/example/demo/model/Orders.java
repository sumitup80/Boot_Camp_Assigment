package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table (name = "orders")
public class Orders  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	
	@Column(name = "order_number")
	private String orderNumber;
	
	@Column(name = "order_description")
	private String orderDescription;
	
	@Column(name = "customer_id")
	private Integer customerId;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "order_date")
	private Date orderDate;
	
	@Column(name = "status")
	private String status;
	
	@OneToMany(fetch = FetchType.LAZY,
			 cascade = {CascadeType.ALL})
	@JoinColumn(name = "order_id", nullable = false)
	private List<OrderDetail> orderDetail;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getOrderDescription() {
		return orderDescription;
	}

	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<OrderDetail> getOrderDetail() {return orderDetail;}

	public void setOrderDetail(List<OrderDetail> orderDetail) {this.orderDetail = orderDetail;}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderNumber=" + orderNumber + ", orderDescription=" + orderDescription
				+ ", customerId=" + customerId + ", totalAmount=" + totalAmount + ", orderDate=" + orderDate
				+ ", status=" + status + ", orderDetails" + orderDetail + "]";
	}
}
