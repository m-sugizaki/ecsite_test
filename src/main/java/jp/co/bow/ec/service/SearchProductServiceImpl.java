package jp.co.bow.ec.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.bow.ec.entity.ProductEntity;
import jp.co.bow.ec.repository.ProductRepository;

@Service
public class SearchProductServiceImpl implements SearchProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductEntity> searchResult(ProductEntity product) {
		return productRepository.searchResult(product);
	}

	@Override
	public ProductEntity findOneProduct(String product_id) {
		return productRepository.findOneProduct(product_id);
	}

}