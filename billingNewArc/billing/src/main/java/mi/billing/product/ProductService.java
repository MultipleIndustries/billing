package mi.billing.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductMaster save(ProductMaster product) throws Exception {
		return productRepository.save(product);
	}

	public void delete(ProductMaster product) {
		productRepository.delete(product);
	}

	public ProductMaster restore(ProductMaster product) {
		return productRepository.save(product);
	}

	public ProductMaster update(ProductMaster product) throws Exception {
		return productRepository.save(product);
	}

	public ProductMaster findById(long productId) {
		return productRepository.findOne(productId);
	}

	public List<ProductMaster> findAllProducts() {
		return productRepository.findAll();
	}
	
	
}
