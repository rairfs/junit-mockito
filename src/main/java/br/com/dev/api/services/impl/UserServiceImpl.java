package br.com.dev.api.services.impl;

import br.com.dev.api.domain.User;
import br.com.dev.api.repositories.UserRepository;
import br.com.dev.api.services.UserService;
import br.com.dev.api.services.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository usuarioRepository;

    public UserServiceImpl(UserRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public User findById(Integer id) {
        Optional<User> obj = usuarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado!"));
    }

    @Override
    public List<User> findAll() {
        return usuarioRepository.findAll();
    }
}
