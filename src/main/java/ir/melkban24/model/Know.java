package ir.melkban24.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="TblKnow")
public class Know {
	
	@Id 
	private Double idKnow;
	private String SubjectKnow;
	private String BodyKnow;
	private String ImgKnow;
	private double CountView;
	
	public Double getIdKnow() {
		return idKnow;
	}

	public void setIdKnow(Double IdKnow) {
		idKnow = IdKnow;
	}

	public String getSubjectKnow() {
		return SubjectKnow;
	}

	public void setSubjectKnow(String subjectKnow) {
		SubjectKnow = subjectKnow;
	}

	@JsonIgnore
	public String getBodyKnow() {
		return BodyKnow;
	}

	public void setBodyKnow(String bodyKnow) {
		BodyKnow = bodyKnow;
	}
	
	
	@JsonIgnore
	public String getImgKnow() {
		return ImgKnow;
	}

	public void setImgKnow(String imgKnow) {
		ImgKnow = imgKnow;
	}

	@JsonIgnore
	public double getCountView() {
		return CountView;
	}

	public void setCountView(double countView) {
		CountView = countView;
	}

	@Transient
	public String getURL()
	{
		return SubjectKnow.replace(" ", "-");
		
	}
	
	

	@Transient
	public String getKnowBodyNOhtml()
	{
		String KnowBodyNOhtml="";
		if (BodyKnow !=null)
		  {
			KnowBodyNOhtml =BodyKnow.replaceAll("\\<.*?>","");
			if (KnowBodyNOhtml.length()>400)
			{
				KnowBodyNOhtml=KnowBodyNOhtml.substring(0, 400);
			}
			else
			{
				KnowBodyNOhtml=KnowBodyNOhtml.substring(0, KnowBodyNOhtml.length());
			}
		  }
		
		return KnowBodyNOhtml;
		
	}
	
	
	@Override
	public String toString(){
		return "id="+idKnow+", SubjectKnow="+SubjectKnow+", ImgKnow="+ImgKnow + ", CountView="+CountView;
	}

}
