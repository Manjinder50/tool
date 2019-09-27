package com.rentManagement.tool.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "property_tenant")
public class PropertyTenant {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "propTen_seq")
	@Column(name = "property_tenant_id")
	private Integer propertyTenantId;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "property_number")
	private Property property;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="tenant_id")
	private Tenant tenant;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;	
}
