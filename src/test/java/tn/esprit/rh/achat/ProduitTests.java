package tn.esprit.rh.achat;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@ExtendWith(MockitoExtension.class)

public class ProduitTests {
	@Mock
	ProduitRepository produitRepository;
	@InjectMocks
	ProduitServiceImpl produitServiceImpl;

@Test

public void retrieveAllFProduitTest() {
when(produitRepository.findAll()).thenReturn((List<Produit>) Stream
.of(new Produit("produit","prod123",1.2f,new Date("15/10/2022"),new Date("23/10/2022")),new Produit("produit","prod123",1,new Date("15/10/2022"),new Date("23/10/2022"))));
assertEquals(2,produitServiceImpl.retrieveAllProduits().size());
}

@Test
public void retrieveProduitTest() {
Long id = (long) 3;
when(produitRepository.findById(id)).thenReturn(Optional.of(new Produit("produit","prod123",1.2f,new Date("15/10/2022"),new Date("23/10/2022"))));
Produit f = produitServiceImpl.retrieveProduit(id);
assertNotNull(f);
verify(produitRepository).findById(Mockito.anyLong());
}

@Test
public void saveProduitTest() {
Produit f = new Produit("produit","prod123",1.2f,new Date("15/10/2022"),new Date("23/10/2022"));
when(produitRepository.save(f)).thenReturn(f);
assertEquals(f, produitServiceImpl.addProduit(f));
}


}
