package com.skillsunion.shoppingcartapi;

import java.util.List;

import com.skillsunion.shoppingcartapi.entity.Cart;
import com.skillsunion.shoppingcartapi.entity.Catalogue;
import com.skillsunion.shoppingcartapi.repository.CartRepository;

public class CartServiceImpl implements CartService {

    private CartRepository cartRepository;

    // GET ALL
    @Override
    public List<Cart> list() {
        List<Cart> allCart = cartRepository.findAll();
        return allCart;
    }

    // GET ONE
    @Override
    public Cart get(Integer id) {
        Cart foundCart = cartRepository.findById(id).get();
        return foundCart;

    }

    // CREATE

    @Override
    public Cart create(Cart cart) {

        Catalogue catalogue = new Catalogue();
        catalogue.setId(cart.getId());
        Cart newCart = new Cart();
        newCart.setItem(catalogue);
        newCart.setQuantity(cart.getQuantity());

        return cartRepository.save(newCart);
    }

}
