package com.rentManagement.tool.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
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
@Table(name = "monthly_rental")
public class MonthlyRental {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "month_seq")
	@Column(name = "monthly_rental_id")
	private Integer monthlyRentalId;
	
	@Column(name = "month")
	private String month;
	
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "paid",columnDefinition = "boolean default false")
	private boolean paid;
	
	@Column(name = "expenses")
	private Double expenses;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "property_tenant_id")
	private Set<PropertyTenant> tenants;
	
	@Column(name = "expenses_detail")
	private ExpenseDetail expenseDetail;
	
	@Column(name = "created_date")
	@Temporal(TemporalType.DATE)
	private Date createdDate;
	
	@Column(name = "updated_date")
	@Temporal(TemporalType.DATE)
	private Date updatedDate;	
}
