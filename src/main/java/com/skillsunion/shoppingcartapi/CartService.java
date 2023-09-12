package com.skillsunion.shoppingcartapi;

import java.util.List;

import com.skillsunion.shoppingcartapi.entity.Cart;

public interface CartService {

    List<Cart> list();

    Cart get(Integer id);

    Cart create(Cart cart);

}
