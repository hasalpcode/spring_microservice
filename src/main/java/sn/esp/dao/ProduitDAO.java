package sn.esp.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sn.esp.entity.*;
import sn.esp.repository.*;

@Service
public class ProduitDAO {
	@Autowired
	private ProduitRepository produitRepository;
	
	public List<Produit>ListeProduits(){
		return produitRepository.findAll();
	}
	

	
	@Transactional
	public Produit createProduit(Produit produit){
		produitRepository.save(produit);
		return produit;
	}
	
	@Transactional
	public void editProduit(Produit produit){
		produitRepository.save(produit);
	}
	
	public Produit findProduit(Integer codeprod){
		return produitRepository.findById(codeprod).orElse(null);
	}
	
	@Transactional
	public void destroyProduit(Integer codeprod){
		Produit produit = findProduit(codeprod);
		if(produit != null) {
			produitRepository.delete(produit);
		}
	}

}
