package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void addElement(){
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1,"Хлеб",100);

        repository.add(product1);

       Product[] expected = repository.findAll();
       Product[] actual = {product1};

       Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void throwingAnException(){
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1,"Хлеб",100);

        repository.add(product1);


        Assertions.assertThrows(NotFoundException.class,()->{
            repository.removeById(2);
        });

    }

}