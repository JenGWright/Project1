import org.example.Exception.SellerException;
import org.example.Model.Seller;
import org.example.Service.ProductService;
import org.example.Service.SellerService;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class ProductSellerTest {

    ProductService productService;
    SellerService sellerService;

    @Before

    public void setUp() throws SellerException {
        sellerService = new SellerService();
        productService = new ProductService(sellerService);

        productService = new ProductService(sellerService);

    }
//
//    @Test
 //   Public void productServiceEmptyAtStart() {
 //   List}
}


