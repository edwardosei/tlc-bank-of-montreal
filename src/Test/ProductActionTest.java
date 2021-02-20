package Test;

import com.turntabl.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductActionTest {

    @Mock
    private ProductPricingService productPricingService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    Stock stock1 = new Stock("p100","APPL", "WT1");
    Stock stock2 = new Stock("p101", "WS1", "WT2");
    Future future1 = new Future("P103", "Z500", "T01",3, 2022);
    Future future2 = new Future("P104", "Z501", "T02",3, 2023);

    @Test
    void addNewProductTest() throws ProductAlreadyRegisteredException {

        ProductAction productAction = new ProductAction(productPricingService);

        productAction.addNewProduct(stock1);
        assertEquals(stock1, productAction.getListOfRegisteredProducts().get(0), "Adding a stock product failed!");

        productAction.addNewProduct(future1);
        assertEquals(future1, productAction.getListOfRegisteredProducts().get(1), "Adding a future product failed!");

        assertThrows(ProductAlreadyRegisteredException.class, () -> {
            productAction.addNewProduct(stock1);
        });

    }

    @Test
    void trade() throws ProductAlreadyRegisteredException {
        ProductAction productAction = new ProductAction(productPricingService);
        productAction.addNewProduct(stock2);
        productAction.trade(stock2, 5);
        assertEquals(stock2, productAction.getListOfProductsTraded().get(0).getProduct(), "Adding a stock trade failed!");
        assertEquals(5, productAction.getListOfProductsTraded().get(0).getQuantity(), "Adding a stock quantity failed!");
    }

    @Test
    void totalTradeQuantityForDay() throws ProductAlreadyRegisteredException {

        ProductAction productAction = new ProductAction(productPricingService);

        productAction.addNewProduct(future2);
        productAction.trade(future2, 5);

        productAction.addNewProduct(stock2);
        productAction.trade(stock2, 5);

        assertEquals(10, productAction.totalTradeQuantityForDay(), "Incorrect quantity value!");
    }

    @Test
    void totalValueOfDaysTradedProducts() throws ProductAlreadyRegisteredException {
        ProductAction productAction = new ProductAction(productPricingService);

        productAction.addNewProduct(future2);
        productAction.trade(future2, 5);

        productAction.addNewProduct(stock2);
        productAction.trade(stock2, 3);

        productAction.addNewProduct(stock1);
        productAction.trade(stock1, 8);

        productAction.addNewProduct(future1);
        productAction.trade(future1, 20);

        productAction.trade(stock2, 56);

        Mockito.when(productPricingService.price(Mockito.anyString(), Mockito.anyString())).thenReturn(2.00);

        Mockito.when(productPricingService.price(Mockito.anyString(), Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt())).thenReturn(4.00);

        assertEquals(234,productAction.totalValueOfDaysTradedProducts(), "Mock pricing for products failed!");
    }
}