package learnsb.demo.business.concretes;

import learnsb.demo.business.abstracts.ProductService;
import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.core.utilities.results.SuccesDataResult;
import learnsb.demo.core.utilities.results.SuccessResult;
import learnsb.demo.dataAccess.abstracts.ProductDao;
import learnsb.demo.entities.concretes.Product;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public DataResult<List<Product>> getAll(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo-1, pageSize);
        return new SuccesDataResult<List<Product>>(this.productDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Product>> getAllSorted() {
        Sort sort = Sort.by(Sort.Direction.DESC, "productName");
        return new SuccesDataResult<List<Product>>(this.productDao.findAll(sort),"Basarili.");
    }

    @Override
    public Result add(Product product) {
        this.productDao.save(product);
        return new SuccessResult("Urun eklendi");
    }



    @Override
    public DataResult<Product> getByProductName(String productName) {

        //business code yazilir
        return new SuccesDataResult<Product>(this.productDao.getByProductName(productName), " Data listelendi");
    }

    @Override
    public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) {
        return new SuccesDataResult<Product>(this.productDao.getByProductNameAndCategory_CategoryId(productName, categoryId), " Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
        return new SuccesDataResult<List<Product>>(this.productDao.getByProductNameOrCategory_CategoryId(productName, categoryId), " Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories) {
        return new SuccesDataResult<List<Product>>(this.productDao.getByCategoryIn(categories), " Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameContains(String productName) {
        return new SuccesDataResult<List<Product>>(this.productDao.getByProductNameContains(productName), " Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
        return new SuccesDataResult<List<Product>>(this.productDao.getByProductNameStartsWith(productName), " Data listelendi");
    }

    @Override
    public DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId) {
        return new SuccesDataResult<List<Product>>(this.productDao.getByNameAndCategory(productName, categoryId), " Data listelendi");
    }

}
