package sn.esp.metier;

import sn.esp.entity.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sn.esp.dao.*;

@Service
public class ProduitProcessings {
	@Autowired
	private ProduitDAO produitDAO;
	
	public Integer compter()
	{
		List<Produit> liste = produitDAO.ListeProduits();
		Integer ct=0;
		for (Produit x : liste)
		{
			ct++;
		}
		return ct;
	}
}