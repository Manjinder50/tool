package com.rentManagement.tool.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tenant")
public class Tenant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ten_seq")
	@Column(name = "tenant_id")
	private Integer tenantId;
	
	@Column(name = "tenant_name")
	private String tenantName;
	
	@Column(name = "tenant_type")
	private String tenantType;
	
	@OneToOne(mappedBy = "tenant", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
	private PropertyTenant propertyTenant;
	
	@Column(name = "tenant_address")
	private String tenantAddress;
	
	@Column(name = "tenant_dob")
	@Temporal(TemporalType.DATE)
	private Date tenantDOB;
}
