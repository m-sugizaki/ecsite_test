package jp.co.bow.ec.repository;

import java.util.List;

import jp.co.bow.ec.entity.ProductEntity;

public interface ProductRepository {
	List<ProductEntity> searchResult(ProductEntity product);

	ProductEntity findOneProduct(String product_id);
}