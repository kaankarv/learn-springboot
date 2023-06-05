package learnsb.demo.api.controllers;


import learnsb.demo.business.abstracts.ProductService;
import learnsb.demo.core.utilities.results.DataResult;
import learnsb.demo.core.utilities.results.Result;
import learnsb.demo.entities.concretes.Product;
import learnsb.demo.entities.dtos.ProductWithCategoryDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsController {


    private final ProductService productService;

    public ProductsController(ProductService productService) {
        super();
        this.productService = productService;
    }



    @GetMapping("/getall")
    public DataResult<List<Product>> getALL(){
        return this.productService.getAll();
    }
    @GetMapping("/getAllByPage")
    public DataResult<List<Product>> getALL(int pageNo, int pageSize){
        return this.productService.getAll(pageNo, pageSize);
    }

    @GetMapping("/getAllDesc")
    public DataResult<List<Product>> getAllSorted(){
        return this.productService.getAllSorted();
    }
    @GetMapping("/getProductWithCategoryDetails")
    public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails(){
        return this.productService.getProductWithCategoryDetails();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Product product){
        return this.productService.add(product);
    }

    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return  this.productService.getByProductName(productName);
    }

    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategoryId(productName, categoryId);
    }

    @GetMapping("/getByProductNameContains")
    public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }


}
