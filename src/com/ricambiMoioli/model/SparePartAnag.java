package com.ricambiMoioli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sparePartAnag")
public class SparePartAnag {
	public SparePartAnag()
	{
		
	}
	
	public SparePartAnag(int codSpa, String description )
	{
		this.codSpa=codSpa;
		this.description=description;
	}
	

	public int getCodSpa() {
		return codSpa;
	}

	public void setCodSpa(int codSpa) {
		this.codSpa = codSpa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Id
	@GeneratedValue
	@Column(name="cod_spa")
	int codSpa;
	@Column(name="desc_spa")
	String description;
	
}
