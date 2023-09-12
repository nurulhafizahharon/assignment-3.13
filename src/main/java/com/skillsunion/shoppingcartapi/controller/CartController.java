package com.skillsunion.shoppingcartapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skillsunion.shoppingcartapi.CartService;
import com.skillsunion.shoppingcartapi.entity.Cart;

/*
    Assignment:
    - Apply @RestController to the class.
    - Apply @GetMapping and @PostMapping to the methods.
    - Apply @PathVariable to the method parameter of get(int).

    Test:
    - Use a client HTTP Tool like YARC to consume the API you have just created.
    E.g. https://chrome.google.com/webstore/detail/yet-another-rest-client/ehafadccdcdedbhcbddihehiodgcddpl?hl=en
*/

@RestController
@RequestMapping("/carts")
public class CartController {

    private CartService cartService;

    // GET ALL
    @GetMapping("")
    public ResponseEntity<List<Cart>> list() {
        return new ResponseEntity<>(cartService.list(), HttpStatus.OK);
    }

    // @GetMapping(value="path")
    // public SomeData getMethodName(@RequestParam String param) {
    // return new SomeData();
    // }

    // GET ONE
    @GetMapping("{id}")
    public ResponseEntity<Cart> get(@PathVariable Integer id) {
        return new ResponseEntity<>(cartService.get(id), HttpStatus.OK);
    }

    // CREATE
    @PostMapping("")
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {

        return new ResponseEntity<>(cartService.create(cart), HttpStatus.CREATED);
    }
}
