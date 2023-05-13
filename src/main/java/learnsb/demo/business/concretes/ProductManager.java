package learnsb.demo.business.concretes;

import learnsb.demo.business.abstracts.ProductService;
import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.core.utilities.results.SuccesDataResult;
import learnsb.demo.core.utilities.results.SuccessResult;
import learnsb.demo.dataAccess.abstracts.ProductDao;
import learnsb.demo.entities.concretes.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager implements ProductService {

    private final ProductDao productDao;


    public ProductManager(ProductDao productDao) {
        super();
        this.productDao = productDao;
    }


    @Override
    public DataResult<List<Product>> getAll() {
        return new SuccesDataResult<List<Product>>(this.productDao.findAll(), " Data listelendi");


    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Urun eklendi");
    }
}
