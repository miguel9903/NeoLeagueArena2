package co.edu.unbosque.model;

import java.io.Serializable;
import java.util.List;

public class GameDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String description;
    private String logo;
    private String genre; 
    private String platform; 
    private List<String> modes;
    
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getLogo() {
		return logo;
	}
	
	public void setLogo(String logo) {
		this.logo = logo;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	public List<String> getModes() {
		return modes;
	}
	
	public void setModes(List<String> modes) {
		this.modes = modes;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}  

}
