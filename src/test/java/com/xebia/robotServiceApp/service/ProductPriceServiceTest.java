package com.xebia.robotServiceApp.service;

import com.xebia.robotServiceApp.domain.Robot;
import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.entity.ProductEntity;
import com.xebia.robotServiceApp.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductPriceServiceTest {

    @InjectMocks
    ProductPriceService service;

    @Mock
    ProductRepository repo;


    @Test
    public void testGetProductPrice() throws Exception {

        Robot robot = createRobot();

        ProductEntity prodEntity = createProduct();

        Optional<ProductEntity> prod = Optional.of(prodEntity);

        when(repo.findById(robot.getBarCode())).thenReturn(prod);

        RobotResponse response = service.getProductPrice(robot);

        assertEquals("5.0",response.getMessage());

    }

    private ProductEntity createProduct() {
        ProductEntity prod = new ProductEntity();
        prod.setId(1L);
        prod.setPrice(5.00);
        return prod;
    }

    private Robot createRobot() {

        Robot robot = new Robot();
        robot.setBarCode(1L);
        return robot;
    }

}
