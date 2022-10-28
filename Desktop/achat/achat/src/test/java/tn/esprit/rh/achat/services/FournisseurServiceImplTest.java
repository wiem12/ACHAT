package tn.esprit.rh.achat.services;
import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.services.IFournisseurService;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class FournisseurServiceImplTest {

	
	@Autowired
	IFournisseurService fs;

	@Test
	@Order(1)
	public void RetrieveAllFournisseur() {
	List<Fournisseur> listFournisseur = fs.retrieveAllFournisseurs();
	//Assertions.assertEquals(0, listFournisseur.size());
	    assertEquals(0, listFournisseur.size());

	}


	@Test
	   void addFournisseur() {
	       Fournisseur f1 = new Fournisseur();
	       f1.setCode("test code");
	       f1.setLibelle("test liblle");
	       
	       Fournisseur savedFournisseur1= fs.addFournisseur(f1);
	       assertEquals(f1.getLibelle(), savedFournisseur1.getLibelle());
	       
	   }



	     @Test
	     void deleteFournisseur() {
	       fs.deleteFournisseur(0L);
	      }
	     
	     

	      @Test
	     void updateFournisseur() {
	       Fournisseur f1= fs.retrieveFournisseur(0L);
	       f1.setLibelle("test");;;
	       Fournisseur updatedFournisseur1= fs.updateFournisseur(f1);
	       assertEquals(f1.getLibelle(), updatedFournisseur1.getLibelle());
	      }



	@Test
	   void retrieveFournisseur() {
	       fs.retrieveFournisseur(0L);
	   }

	
}
