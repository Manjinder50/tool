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
@Table(name = "property")
public class Property {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "prop_sequence")
	@Column(name = "property_number")
	private Integer propertyNumber;
	
	@Column(name = "property_name")
	private String propertyName;
	
	@Column(name = "address")
	private String address;
	
	@OneToOne(mappedBy = "property", cascade = CascadeType.ALL,
              fetch = FetchType.LAZY, optional = false)
	private PropertyTenant propertyTenant;
	
	@Column(name = "active",columnDefinition = "boolean default false")
	private boolean active;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;	
}
