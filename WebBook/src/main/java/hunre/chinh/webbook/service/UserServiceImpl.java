package hunre.chinh.webbook.service;

import hunre.chinh.webbook.dto.UserDto;
import hunre.chinh.webbook.entity.Role;
import hunre.chinh.webbook.entity.User;
import hunre.chinh.webbook.repository.RoleRepository;
import hunre.chinh.webbook.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final RoleRepository roleRepository;
  private final PasswordEncoder passwordEncoder;

  public UserServiceImpl(UserRepository userRepository,
                         RoleRepository roleRepository,
                         PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public void saveUser(UserDto userDto) {
    User user = new User();
    user.setName(userDto.getName());
    user.setGender(userDto.getGender());
    user.setBirthday(userDto.getBirthday());
    user.setAddress(userDto.getAddress());
    user.setPhone(userDto.getPhone());
    user.setEmail(userDto.getEmail());
    // encrypt the password using spring security
    user.setPassword(passwordEncoder.encode(userDto.getPassword()));

    Role role = roleRepository.findByName("ROLE_ADMIN");
    if (role == null) {
      role = checkRoleExist();
    }
    user.setRoles(Arrays.asList(role));
    userRepository.save(user);
  }

  @Override
  public User findUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
        .map(this::mapToUserDto)
        .collect(Collectors.toList());
  }

  private UserDto mapToUserDto(User user) {
    UserDto userDto = new UserDto();
//        String[] str = user.getName().split(" ");
//        userDto.setFirstName(str[0]);
//        userDto.setLastName(str[1]);
    userDto.setName(user.getName());
    userDto.setGender(user.getGender());
    userDto.setBirthday(user.getBirthday());
    userDto.setAddress(user.getAddress());
    userDto.setPhone(user.getPhone());
    userDto.setEmail(user.getEmail());
    return userDto;
  }

  private Role checkRoleExist() {
    Role role = new Role();
    role.setName("ROLE_ADMIN");
    return roleRepository.save(role);
  }

  //@Primary
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//    return new BCryptPasswordEncoder();
//  }

}
