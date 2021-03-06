package ir.melkban24.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblRange")
public class Range {
	
	
	@Id
	@Column(name="IdRange")
	private double IdRange;
	
	@Column(name="NameRange")
	private String NameRange;
	
	@Column(name="IdArea")
	private Double IdArea;

	public double getIdRange() {
		return IdRange;
	}

	public void setIdRange(double idRange) {
		IdRange = idRange;
	}

	public String getNameRange() {
		return NameRange;
	}

	public void setNameRange(String nameRange) {
		NameRange = nameRange;
	}

	public Double getIdArea() {
		return IdArea;
	}

	public void setIdArea(Double idArea) {
		this.IdArea = idArea;
	}


	@Override
	public String toString(){
		return "id="+IdRange+", NameRange="+NameRange+", IdArea="+IdArea;
	}
	
}
