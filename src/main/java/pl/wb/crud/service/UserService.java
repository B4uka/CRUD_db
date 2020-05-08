package pl.wb.crud.service;

import pl.wb.crud.entity.User;

import java.util.List;


public interface UserService {

	List<User> findAll ();
	
	User findById (int theId);
	
	void save (User theUser);
	
	void deleteById (int theId);
	
}
