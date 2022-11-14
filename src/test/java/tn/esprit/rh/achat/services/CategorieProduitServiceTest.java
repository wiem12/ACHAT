package tn.esprit.rh.achat.services;

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
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

@ExtendWith(MockitoExtension.class)

public class CategorieProduitServiceTest {
	
	@Mock
	CategorieProduitRepository categorieRepository;
	
	@InjectMocks
	CategorieProduitServiceImpl categorieService;
	
	
	@Test
	public void retrieveProduitTest() {
	Long id = (long) 3;
	when(categorieRepository.findById(id)).thenReturn(Optional.of(new CategorieProduit("produit","prod123")));
	CategorieProduit f = categorieService.retrieveCategorieProduit(id);
	assertNotNull(f);
	verify(categorieRepository).findById(Mockito.anyLong());
	}

	@Test
	public void saveProduitTest() {
	CategorieProduit f = new CategorieProduit("produit","prod123");
	when(categorieRepository.save(f)).thenReturn(f);
	assertEquals(f, categorieService.addCategorieProduit(f));
	}


	}