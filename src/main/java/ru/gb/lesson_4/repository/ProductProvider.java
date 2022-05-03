package ru.gb.lesson_4.repository;

import ru.gb.lesson_4.model.Product;

import java.util.List;

public interface ProductProvider {
    List<Product> getProduct();
}