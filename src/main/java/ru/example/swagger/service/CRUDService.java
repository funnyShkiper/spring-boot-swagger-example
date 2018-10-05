package ru.example.swagger.service;

import java.util.List;

public interface CRUDService<T> {

    List<?> listAll();

    T getById(Integer id);

    T saveOrUpdate(T object);

    void delete(Integer id);

}
