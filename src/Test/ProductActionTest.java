package Test;

import com.turntabl.Product;
import com.turntabl.ProductPricingService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class ProductActionTest {

    @Mock
    private ProductPricingService productPricingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    Product product = new Product("P100",50.0);

    @org.junit.jupiter.api.Test
    void addNewProduct() {

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