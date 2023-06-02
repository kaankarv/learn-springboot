package learnsb.demo.business.abstracts;

import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.entities.concretes.Product;
import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductService {
    //bu ikisi zaten jpa repositorynin icinde default geliyo findall ve save olarak
    DataResult<List<Product>> getAll();

    Result add(Product product);



    DataResult<Product> getByProductName(String productName);

    DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId);

    DataResult<List<Product>> getByCategoryIdIn(List<Integer> categories);

    DataResult<List<Product>> getByProductNameContains(String productName);

    DataResult<List<Product>> getByProductNameStartsWith(String productName);

    DataResult<List<Product>> getByNameAndCategory(String productName, int categoryId);
}
