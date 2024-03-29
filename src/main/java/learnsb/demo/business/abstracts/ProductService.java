package learnsb.demo.business.abstracts;

import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.entities.concretes.Product;
import learnsb.demo.entities.dtos.ProductWithCategoryDto;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    //bu ikisi zaten jpa repositorynin icinde default geliyo findall(getall) ve save(add) olarak
    DataResult<List<Product>> getAll();

    //sayfalama
    DataResult<List<Product>> getAll(int pageNo, int pageSize);
    DataResult<List<Product>> getAllSorted();

    Result add(Product product);



    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);

    DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails();
}
