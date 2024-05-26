package br.com.dev.api.services;

import br.com.dev.api.domain.User;
import br.com.dev.api.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
    User create(UserDTO userDTO);
    User update(UserDTO userDTO);
    void delete(Integer id);
}
