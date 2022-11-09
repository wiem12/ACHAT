package tn.esprit.rh.achat.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImpMock {
	@Mock
  FournisseurRepository fournisseurRepository;
 
  @InjectMocks
  FournisseurServiceImpl fournisseurService;
 
  Fournisseur fournisseur = new Fournisseur(null, "11","12", null, null, null, null);
 
  List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>() {
      {
          add(new Fournisseur(null, "1","rim", null, null, null, null));
          add(new Fournisseur(null, "2","jihen", null, null, null, null));
         
      }
     
      @Test
      void retrieveOperateur() {
          Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
          Fournisseur fournisseur1 = fournisseurService.retrieveFournisseur(1L);
          Assertions.assertNotNull(fournisseur1);
      }
 };
}
