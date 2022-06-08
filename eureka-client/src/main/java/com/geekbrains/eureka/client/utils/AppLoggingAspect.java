package com.geekbrains.eureka.client.utils;

import com.geekbrains.eureka.client.entites.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppLoggingAspect {

    private static final Logger LOGGER = LogManager.getLogger(AppLoggingAspect.class);

    @Before("execution(public * com.geekbrains.eureka.client.services.ShoppingCartService.addToCart(..)) && args(*, productId, ..)")
    public void beforeAddToCart(Long productId) {
        LOGGER.info("Добавлен в корзину товар с ID: " + productId);
    }

    @Before("execution(public * com.geekbrains.eureka.client.services.ShoppingCartService.removeFromCart(..)) && args(*, productId, ..)")
    public void beforeRemoveFromCart(Long productId) {
        LOGGER.info("Удален из корзины товар с ID: " + productId);
    }

    @Before("execution(public * com.geekbrains.eureka.client.services.ProductService.saveProduct(..)) && args(product)")
    public void beforeEditProduct(Product product) {
        LOGGER.info("В каталог товаров сохранен продукт " + product.getTitle());
    }

    @AfterReturning(
            pointcut = "execution(public * com.geekbrains.eureka.client.services.ShoppingCartService.getCurrentCart(..))",
            returning = "cart")
    public void afterGetTotalCoast(ShoppingCart cart) {
        LOGGER.info("Стоимость товаров в корзине: " + cart.getTotalCost());
    }

}