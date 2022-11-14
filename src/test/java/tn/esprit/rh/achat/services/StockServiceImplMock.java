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


import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
	
	@Mock
	StockRepository stockRepository;
	@InjectMocks
	StockServiceImpl stockService;
	
	@Test
	public void retrieveAllStockTest() {
		when(stockRepository.findAll()).thenReturn((List<Stock>) Stream
				.of(new Stock("jihen",50,30),new Stock("jajou",100,50))
				.collect(Collectors.toList()));
		assertEquals(2,stockService.retrieveAllStocks().size());
	}
	
	@Test
	public void retrieveStockTest() {
		Long id = (long) 3;
		when(stockRepository.findById(id)).thenReturn(Optional.of(new Stock("jiji",200,60)));
		Stock s = stockService.retrieveStock(id);
		assertNotNull(s);
		verify(stockRepository).findById(Mockito.anyLong());
	}
	
	@Test
	public void saveStockTest() {
		Stock s = new Stock("tatou",60,30);
		when(stockRepository.save(s)).thenReturn(s);
		assertEquals(s, stockService.addStock(s));
	}
	
	
}