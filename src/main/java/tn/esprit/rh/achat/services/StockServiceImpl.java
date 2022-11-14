package tn.esprit.rh.achat.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;



@Service
@Slf4j
public class StockServiceImpl implements IStockService {

	@Autowired
	StockRepository stockRepository;




	@Override
	public List<Stock> retrieveAllStocks() {


		List<Stock> stocks = stockRepository.findAll();

		log.info("getting data from db"+ stocks);

		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {


		return stockRepository.save(s);
		
	}

	@Override
	public Stock getStckByid(Long id) {



		return stockRepository.getById(id);

	}



	@Override
	public void deleteStockById(Long stockId) {

		stockRepository.deleteById(stockId);

	}

	@Override
	public void deleteStock(Stock s) {

		stockRepository.delete(s);

	}

	@Override
	public Stock updateStock(Stock s) {

		return stockRepository.save(s);
	}

	@Override
	public Stock retrieveStock(Long stockId) {


		return stockRepository.findById(stockId).orElse(null);





	}

	  @Override
	   public StringBuilder retrieveStatusStock() {

		List<Stock> stocksEnRouge = stockRepository.retrieveStatusStock();

		StringBuilder finalMessage = new StringBuilder();
		for (int i = 0; i < stocksEnRouge.size(); i++) {

			finalMessage.append(stocksEnRouge.get(i).getLibelleStock()).append(stocksEnRouge.get(i).getQte()).append(stocksEnRouge.get(i).getQteMin()).toString();





		}
		log.info(String.valueOf(finalMessage));
		return finalMessage;
	}

}