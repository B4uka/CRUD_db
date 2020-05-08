package pl.wb.crud.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.wb.crud.entity.User;

import java.util.List;

//https://stackoverflow.com/questions/14014086/what-is-difference-between-crudrepository-and-jparepository-interfaces-in-spring
public interface UserRepository extends JpaRepository<User, Integer> {

    // add a method to sort users data by last name
    List<User> findAllByOrderByLastNameAsc();
}
