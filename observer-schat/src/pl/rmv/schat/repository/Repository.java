package pl.rmv.schat.repository;

public interface Repository<T> {
    <S extends T> S save(S entity);
    T findOne(T item);
    Long count();
    void delete(T entity);
}
