package ir.melkban24.model;


import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;

@Entity
@Table(name="TblNews")
public class News {
	
	
	@Id
	private Double idNews;

	private String dateNews;
	
	private String absNews;
	
	private String subjectNews;
	
	private String bodyNews;
	
	private String imageNews;
	
	
	

	
	public Double getIdNews() {
		return idNews;
	}

	public void setIdNews(Double idNews) {
		this.idNews = idNews;
	}

	
	public String getDateNews() {
		return dateNews;
	}

	public void setDateNews(String dateNews) {
		this.dateNews = dateNews;
	}

	@JsonIgnore
	public String getAbsNews() {
		return absNews;
	}

	
	public void setAbsNews(String absNews) {
		this.absNews = absNews;
	}

	
	public String getSubjectNews() {
		return subjectNews;
	}

	
	public void setSubjectNews(String subjectNews) {
		this.subjectNews = subjectNews;
	}

	@JsonIgnore
	public String getBodyNews() {
		return bodyNews;
	}

	public void setBodyNews(String bodyNews) {
		this.bodyNews = bodyNews;
	}

	public String getImageNews() {
		return imageNews;
	}

	public void setImageNews(String imageNews) {
		this.imageNews = imageNews;
	}

	@Transient
	public String getURL()
	{
		return subjectNews.replace(" ", "-");
		
	}
	
	@Transient
	public String getThImagenews() {
		 
		String thImagenews="";
		if (imageNews !=null)
		  {
			thImagenews =imageNews.replace("News", "th-News").replace("http://melkban24.ir", "");
		  }
		return thImagenews;
	}
	
	

	@Transient
	public String getNewBodyNOhtml()
	{
		String NewBodyNOhtml="";
		if (bodyNews !=null)
		  {
			NewBodyNOhtml =bodyNews.replaceAll("\\<.*?>","");
			if (NewBodyNOhtml.length()>400)
			{
				NewBodyNOhtml=NewBodyNOhtml.substring(0, 400);
			}
			else
			{
				NewBodyNOhtml=NewBodyNOhtml.substring(0, NewBodyNOhtml.length());
			}
		  }
		
		return NewBodyNOhtml;
		
	}
	
	@Override
	public String toString(){
		return "id="+idNews+", DateNews="+dateNews+", SubjectNews="+subjectNews+"ImageNews="+imageNews;
	}
	
	
	
}
