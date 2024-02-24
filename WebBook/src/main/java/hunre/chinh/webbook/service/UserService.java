package hunre.chinh.webbook.service;

import java.util.List;

import hunre.chinh.webbook.dto.UserDto;
import hunre.chinh.webbook.entity.User;

public interface UserService {
	void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();

}
