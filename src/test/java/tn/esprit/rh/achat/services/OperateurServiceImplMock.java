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

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;



@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplMock {
@Mock
	OperateurRepository operateurRepository;
   
    @InjectMocks
    OperateurServiceImpl operateurService;
   
    Operateur operateur = new Operateur("ss","ff","kk");
   
    List<Operateur> listOperateur = new ArrayList<Operateur>() {
        {
            add(new Operateur("saima","fek","rfr"));
           
        }
       
        @Test
        void retrieveOperateur() {
            Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(operateur));
            Operateur operateur1 = operateurService.retrieveOperateur(1L);
            Assertions.assertNotNull(operateur1);
        }
    };

}