package Test;

import com.turntabl.Product;
import com.turntabl.ProductAction;
import com.turntabl.ProductAlreadyRegisteredException;
import com.turntabl.ProductPricingService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductActionTest {

    @Mock
    private ProductPricingService productPricingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    Product product = new Product("P100",50.0);
    ProductAction productSaleRules = new ProductAction();

    @org.junit.jupiter.api.Test
    void addNewProductTest() throws ProductAlreadyRegisteredException {
        product.setRegistered(true);
        productSaleRules.addNewProduct(product);
        Exception exception = assertThrows(RuntimeException.class, () -> {
            Integer.parseInt("1a");
        });

        String expectedMessage = "Product ID is registered already.";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage), "Add product allows duplicate");
    }

    @org.junit.jupiter.api.Test
    void trade() {
    }

    @org.junit.jupiter.api.Test
    void totalTradeQuantityForDay() {
    }

    @org.junit.jupiter.api.Test
    void totalValueOfDaysTradedProducts() {
    }
}