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

    @Test
    public void deleteProduct(){
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1,"Хлеб",100);
        Product product2 = new Product(2,"Вода",200);

        repository.add(product1);
        repository.add(product2);
        repository.removeById(2);

        Product[] expected = repository.findAll();
        Product[] actual = {product1};

        Assertions.assertArrayEquals(expected,actual);
    }

    @Test
    public void dontAddSameId(){
        ShopRepository repository = new ShopRepository();
        Product product1 = new Product(1,"Хлеб",100);
        Product product2 = new Product(1,"Вода",200);

        repository.add(product1);

        Assertions.assertThrows(AlreadyExistsException.class,()->{
            repository.add(product2);
        });

    }

}