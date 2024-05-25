package br.com.dev.api.services;

import br.com.dev.api.domain.User;

public interface UserService {

    User findById(Integer id);
}
