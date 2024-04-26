package sn.esp.controller;

import sn.esp.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sn.esp.dao.*;

@RestController

// http://localhost:9000/produitapi/...

@RequestMapping("/produitapi")
public class ProduitController {
	@Autowired
	private ProduitDAO produitDao;
	
	
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

}
