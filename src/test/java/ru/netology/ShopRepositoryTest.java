package ru.netology;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void addElement(){
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1,"Хлеб",100);
        Product product2 = new Product(2,"Булка",200);

        repository.add(product1);
        repository.add(product2);

         Product actual[] = repository.findAll();
         System.out.println(actual);
    }

}