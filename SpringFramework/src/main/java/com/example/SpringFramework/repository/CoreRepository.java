package com.example.SpringFramework.repository;

import java.util.List;

public interface CoreRepository<T> {
    List<T> getAll();
    T getById(int id);
    void create(T t);
    T update(T t);
    void delete (int id);
    T getByCode(String code);
}
