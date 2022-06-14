package com.geekbrains.geekmarketwinter;

import com.geekbrains.geekmarketwinter.entites.Category;
import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.services.ShoppingCartService;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpSession;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShoppingCartServiceTest {

    private Product product;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private HttpSession session;

    @Before
    public void init() {
        shoppingCartService.resetCart(session);
        session.removeAttribute("cart");

        Category category = new Category();
        category.setTitle("Test Category");
        category.setDescription("This is test category");
        product = new Product();
        product.setId(6667L);
        product.setPrice(14.0);
        product.setCategory(category);
        product.setTitle("Test Product");
        product.setFullDescription("Test Product Full Description");
        product.setShortDescription("Test Product Short Description");
        product.setVendorCode("66676667");
    }

    @Test
    public void addToCartTest() {
        shoppingCartService.addToCart(session, product);

        Assert.assertEquals(java.util.Optional.of(product.getPrice()), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }

    @Test
    public void addToCartTest2() {
        shoppingCartService.addToCart(session, product);
        shoppingCartService.addToCart(session, product);

        Assert.assertEquals(java.util.Optional.of(product.getPrice() * 2), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }

    @Test
    public void removeFromCartTest() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(product);
        session.setAttribute("cart", cart);

        shoppingCartService.removeFromCart(session, product);

        Assert.assertEquals(java.util.Optional.of(0.0), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }

    @Test
    public void withoutRemoveFromCartTest() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(product);
        session.setAttribute("cart", cart);

        Assert.assertNotEquals(java.util.Optional.of(0.0), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }

    @Test
    public void resetCartTest() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(product);
        session.setAttribute("cart", cart);

        shoppingCartService.resetCart(session);

        Assert.assertEquals(java.util.Optional.of(0.0), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }

    @Test
    public void setProductCountTest() {
        ShoppingCart cart = new ShoppingCart();
        cart.add(product);
        session.setAttribute("cart", cart);

        shoppingCartService.setProductCount(session, product, 3L);

        Assert.assertEquals(java.util.Optional.of(product.getPrice() * 3), java.util.Optional.ofNullable(shoppingCartService.getCurrentCart(session).getTotalCost()));
    }
}
