package com.geekbrains.geekmarketwinter;

import com.geekbrains.geekmarketwinter.entites.Category;
import com.geekbrains.geekmarketwinter.entites.OrderItem;
import com.geekbrains.geekmarketwinter.entites.Product;
import com.geekbrains.geekmarketwinter.services.ShoppingCartService;
import com.geekbrains.geekmarketwinter.utils.ShoppingCart;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class CartControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ShoppingCartService shoppingCartService;

    @Before
    public void init() {
        Category category = new Category();
        category.setTitle("Test Category");
        category.setDescription("This is test category");
        Product product = new Product();
        product.setId(6667L);
        product.setPrice(14.0);
        product.setCategory(category);
        product.setTitle("Test Product");
        product.setFullDescription("Test Product Full Description");
        product.setShortDescription("Test Product Short Description");
        product.setVendorCode("66676667");

        OrderItem orderItem = new OrderItem();
        orderItem.setId(667L);
        orderItem.setItemPrice(product.getPrice());
        orderItem.setProduct(product);
        orderItem.setQuantity(2L);
        orderItem.setTotalPrice(orderItem.getItemPrice() * orderItem.getQuantity());

        List<OrderItem> list = new ArrayList<>();
        list.add(orderItem);

        ShoppingCart cart = new ShoppingCart();
        cart.setItems(list);
        cart.setTotalCost(orderItem.getTotalPrice());

        Mockito.when(shoppingCartService.getCurrentCart(any())).thenReturn(cart);
    }

    @Test
    public void cartControllerTest() throws Exception {
        mockMvc.perform(get("/cart"))
                .andExpect(status().isOk())
                .andExpect(view().name("cart-page"))
                .andExpect(content().string(Matchers.containsString("28.0")))
                .andDo(print())
                .andReturn();
    }
}