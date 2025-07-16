package top.sk370.malldemo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import top.sk370.malldemo.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from Users u where u.name= ?1")
    public List<User> getUserByName(@Param("name") String name);
}
