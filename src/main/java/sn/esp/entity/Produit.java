package sn.esp.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "produits"	)
public class Produit implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codeprod;
	
	@Column(length = 50)
	private String nomprod;
	private Integer prix;
	
	public Produit() {}
	
	
	public Integer getCodeprod() {
		return codeprod;
	}
	public void setCodeprod(Integer codeprod) {
		this.codeprod = codeprod;
	}
	public String getNomprod() {
		return nomprod;
	}
	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}


	
	
}
