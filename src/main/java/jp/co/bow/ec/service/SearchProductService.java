package jp.co.bow.ec.service;

import java.util.List;

import jp.co.bow.ec.entity.ProductEntity;

public interface SearchProductService {
	List<ProductEntity> searchResult(ProductEntity product);

	ProductEntity findOneProduct(String product_id);
}