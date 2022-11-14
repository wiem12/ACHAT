package tn.esprit.rh.achat.services;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)

public class StockServiceImplMock {

        @InjectMocks
        private StockServiceImpl stockservice;

        @Mock
        private StockRepository sr;


        @Test
        public void getStockTest() {

            when(sr.findAll()).thenReturn(Stream
                    .of(new Stock("epuise", 4 , 5), new Stock("test",6,8)).collect(Collectors.toList()));
            Assertions.assertEquals(2, stockservice.retrieveAllStocks().size());
        }

        @Test
        public void addStockTest() {
            Stock s = new Stock("epuise", 4 , 5);
            when(sr.save(s)).thenReturn(s);
            assertEquals(s, stockservice.addStock(s));
        }


        @Test
        public void deleteStockTest() {
            Stock s = new Stock("aaa", 66 , 55);
            stockservice.deleteStock(s);
            verify(sr, times(1)).delete(s);
        }




}