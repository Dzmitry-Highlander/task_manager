package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import java.util.List;

public interface ICRUDDao<T> {
    List<T> get();

    T get(Long id);

    T save(T item);

    T update(T item);

    boolean delete(Long id);
}
