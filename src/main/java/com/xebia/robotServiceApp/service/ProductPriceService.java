package com.xebia.robotServiceApp.service;

import com.xebia.robotServiceApp.domain.Robot;
import com.xebia.robotServiceApp.domain.RobotResponse;
import com.xebia.robotServiceApp.entity.ProductEntity;
import com.xebia.robotServiceApp.exception.ProductException;
import com.xebia.robotServiceApp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductPriceService {

    @Autowired
    private ProductRepository productRepo;

    public RobotResponse getProductPrice(final Robot robot) throws Exception {

        Long barCode = robot.getBarCode();
        if(barCode == null){
            throw new Exception("Scan Failure");
        }

        Double price = null;
        Optional<ProductEntity> productEntity = productRepo.findById(barCode);

        price = productEntity.map(p -> p.getPrice())
                .orElseThrow(ProductException::new);
        RobotResponse response = new RobotResponse();
        response.setMessage(price.toString());
        return response;
    }
}
