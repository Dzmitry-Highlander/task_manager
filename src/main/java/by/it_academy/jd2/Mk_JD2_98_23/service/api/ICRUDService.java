package by.it_academy.jd2.Mk_JD2_98_23.service.api;

import java.util.List;

public interface ICRUDService<T, S> {
    List<T> get();

    T get(int id);

    T save(T item);
}
