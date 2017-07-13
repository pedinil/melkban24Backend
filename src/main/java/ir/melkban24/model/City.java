package ir.melkban24.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TblCity")
public class City {
	
	
	@Id
	@Column(name="IdCity")
	private double IdCity;
	
	@Column(name="NameCity")
	private String NameCity;
	
	
	private Double idstate;
	
	
	public double getIdCity() {
		return IdCity;
	}

	public void setIdCity(double idCity) {
		IdCity = idCity;
	}

	public String getNameCity() {
		return NameCity;
	}

	public void setNameCity(String nameCity) {
		NameCity = nameCity;
	}

	public double getidstate() {
		return idstate;
	}

	public void setidstate(double idState) {
		this.idstate = idState;
	}
	
	
	@Override
	public String toString(){
		return "id="+IdCity+", name="+NameCity+", idState="+idstate;
	}
	
	

}
