package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import java.util.List;

public interface ICRUDDao<T, S> {
    List<S> get();

    T get(int id);

    T save(T item);
}
