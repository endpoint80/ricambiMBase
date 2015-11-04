package com.ricambiMoioli.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "spareParts")
public class SparePart {
	public SparePart()
	{
		//Standard constructor used by Hibernate
	}
	public SparePart(int ID, String description, String modelNumber, Boolean enabled,  int codMan,  int codCat , int codSpa)
	{
		this.ID=ID;
		this.description=description;
		this.modelNumber=modelNumber;
		this.enabled=enabled;
		this.codMan=codMan;
		this.codCat=codCat;
		this.codSpa=codSpa;
	}
	 
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getModelNumber() {
		return modelNumber;
	}
	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public int getCodMan() {
		return codMan;
	}
	public void setCodMan(int codMan) {
		this.codMan = codMan;
	}
	public int getCodCat() {
		return codCat;
	}
	public void setCodCat(int codCat) {
		this.codCat = codCat;
	}
	public int getCodSpa() {
		return codSpa;
	}
	public void setCodSpa(int codSpa) {
		this.codSpa = codSpa;
	}


	@Id 
	@GeneratedValue
	@Column(name = "cod_spp")
	private int ID;
	@Column(name = "desc_spp")
	private String description;
	@Column(name = "modelNumber_spp")
	private String modelNumber;
	@Column(name = "enabled_spp")
	private Boolean enabled;
	@Column(name = "codMan_spp")
	private int codMan;
	@Column(name = "codCat_spp")
	private int codCat;
	@Column(name = "codSpa_spp")
	private int codSpa;
}