package dao;

import java.sql.SQLException;

public interface DaoInterface<T> {
    T login(String username, String password) throws SQLException;
    void delete(T entity) throws SQLException;
    void register(T entity) throws SQLException;
    void update(T entity) throws SQLException;
}
