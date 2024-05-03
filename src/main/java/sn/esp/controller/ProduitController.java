package sn.esp.controller;

import sn.esp.entity.*;
import sn.esp.metier.ProduitProcessings;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import sn.esp.dao.*;

@RestController

// http://localhost:9000/produitapi/...

@RequestMapping("/produitapi")
public class ProduitController {
	@Autowired
	private ProduitDAO produitDao;
	
	@Autowired
	private ProduitProcessings produitProcess;
	
	
	@PostMapping("/produits")
	public ResponseEntity<Produit> ajouterProduit(@RequestBody Produit produit) {
		Produit newProduit = produitDao.createProduit(produit);
		
		return new ResponseEntity(newProduit,HttpStatus.CREATED);
	}
	
	@GetMapping("/produits")
	public ResponseEntity<List<Produit>> getAllProduit() {
		
		List<Produit> liste = produitDao.ListeProduits();
		
		
		return new ResponseEntity(liste,HttpStatus.OK);
	}
	
	
	@GetMapping("/produits/{codeprod}")
	public ResponseEntity<Produit> findProduit(@PathVariable("codeprod") Integer codeprod) {
		
		Produit produit  = produitDao.findProduit(codeprod);	
		if(produit == null) {
			throw new ResourceAccessException("ce produit n'existe pas! "+ codeprod);
		}else{
			return new ResponseEntity<Produit>(produit,HttpStatus.OK);
		}
		
		
		
	}
	
	
	@PutMapping("/produits/{codeprod}")
	public ResponseEntity<Produit> editProduit(@PathVariable("codeprod") Integer codeprod, @RequestBody Produit produit) {
		
		Produit gettedProduit  = produitDao.findProduit(codeprod);	
		if(gettedProduit == null) {
			throw new ResourceAccessException("ce produit n'existe pas! "+ codeprod);
		}else{
			gettedProduit.setCodeprod(produit.getCodeprod());
			gettedProduit.setNomprod(produit.getNomprod());
			gettedProduit.setNomprod(produit.getNomprod());
			gettedProduit.setPrix(produit.getPrix());
			produitDao.editProduit(gettedProduit);
			return new ResponseEntity<Produit>(produit,HttpStatus.OK);
		}
		
		
		
	}

}
