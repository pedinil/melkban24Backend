package ir.melkban24.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="TblCase")
public class CaseLocation {

	
	
	private double Id;
	
	@Id
	private Double idcase;

	
	private Double Lat;
	

	private Double Lon;
	

	private String DateIn;
	
	
	public double getId() {
		return Id;
	}



	public void setId(double id) {
		Id = id;
	}



	public Double getIdcase() {
		return idcase;
	}



	public void setIdcase(Double idcase) {
		this.idcase = idcase;
	}

	public Double getLat() {
		return Lat;
	}


	public void setLat(Double lat) {
		Lat = lat;
	}

	public Double getLon() {
		return Lon;
	}

	public void setLon(Double lon) {
		Lon = lon;
	}


	public String getDateIn() {
		return DateIn;
	}

	public void setDateIn(String dateIn) {
		DateIn = dateIn;
	}



   


	@Override
	public String toString(){
		return "idcase="+idcase+", Lat="+Lat+" Lon="+ Lon;
	}
	
	

	
}
