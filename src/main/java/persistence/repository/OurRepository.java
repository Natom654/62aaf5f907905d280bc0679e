package persistence.repository;

import java.util.Optional;

public interface OurRepository<T, ID> {
    void save(T entity);
    void update(T entity);
    void delete(T entity);
    Optional<T> findById(ID id);
}
