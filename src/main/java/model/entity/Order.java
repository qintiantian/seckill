package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.qintiantian.seckill.model.enums.OrderStatus;

import lombok.Data;

@Data
@Entity
@Table(name = "orders", uniqueConstraints = { @UniqueConstraint(columnNames = "phone") })
@JsonInclude(value = Include.NON_NULL)
public class Order {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "orderId", length = 50, nullable = false)
	private String orderId;

	@Column(name = "userId")
	private Integer userId;

	@Column(name = "productId")
	private Integer productId;

	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private OrderStatus status;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "createDateTime")
	private Date createDateTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "createDateTime")
	private Date lastUpdateDateTime;

	@Column(name = "version")
	private int version;
}
