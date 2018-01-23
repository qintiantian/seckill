package model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.Getter;

@Entity
@Table(name = "user", uniqueConstraints = { @UniqueConstraint(columnNames = "phone") })
@JsonInclude(value = Include.NON_NULL)
@Getter
public class User extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name", length = 20, nullable = false)
	private String name;

	@Column(name = "phone", length = 20, nullable = false)
	private String phone;

	@CreationTimestamp
	// TIMESTAMP yyyy-MM-dd hh:mm:ss 2016-12-07 11:47:58.697这个是会显示到毫秒的
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "createDateTime")
	private Date createDateTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(name = "createDateTime")
	private Date lastUpdateDateTime;
}
