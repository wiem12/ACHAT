package tn.esprit.rh.achat.services;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;

@ExtendWith(MockitoExtension.class)
public class OperateurTests {
	
	@Mock
	OperateurRepository operateurRepository;
	@InjectMocks
	OperateurServiceImpl operateurService;
	
	@Test
	public void retrieveAllFacturesTest() {
		when(operateurRepository.findAll()).thenReturn((List<Operateur>) Stream
				.of(new Operateur("32","65","12"),new Operateur("21","45","13941"))
				.collect(Collectors.toList()));
		assertEquals(2,operateurService.retrieveAllOperateurs().size());
	}
	
	@Test
	public void retrieveOperateurTest() {
		Long id = (long) 3;
		when(operateurRepository.findById(id)).thenReturn(Optional.of(new Operateur("21","45","13941")));
		Operateur o = operateurService.retrieveOperateur(id);
		assertNotNull(o);
		verify(operateurRepository).findById(Mockito.anyLong());
	}
	
	@Test
	public void saveOperateurTest() {
		Operateur o = new Operateur("32","65","12");
		when(operateurRepository.save(o)).thenReturn(o);
		assertEquals(o, operateurService.addOperateur(o));
	}
	
	
}