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
public class FournisserServiceImpMock {
	@Mock
    FournisseurRepository fournisseurRepository;
   
    @InjectMocks
    FournisseurServiceImpl fournisseurService;
   
    Fournisseur fournisseur = new Fournisseur("11","12");
   
    List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>() {
        {
            add(new Fournisseur("1","rim"));
            add(new Fournisseur("2","emna"));
           
        }
       
        @Test
        void retrieveOperateur() {
            Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(fournisseur));
            Fournisseur fournisseur1 = fournisseurService.retrieveFournisseur(1L);
            Assertions.assertNotNull(fournisseur1);
        }
    };

}
