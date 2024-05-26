package br.com.dev.api.services;

import br.com.dev.api.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);
    List<User> findAll();
}
