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

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StockServiceImplMock {
	@Mock
    StockRepository stockRepository;
   
    @InjectMocks
    StockServiceImpl stockService;
   
    Stock stock = new Stock("ji",12,10);
   
    List<Stock> listStock = new ArrayList<Stock>() {
        {
            add(new Stock("jajou",50,20));
            add(new Stock("jiji",100,60));
           
        }
       
        @Test
        void retrieveOperateur() {
            Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
            Stock stock1 = stockService.retrieveStock(1L);
            Assertions.assertNotNull(stock1);
        }
    };

}
