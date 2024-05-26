package br.com.dev.api.services.impl;

import br.com.dev.api.domain.User;
import br.com.dev.api.domain.dto.UserDTO;
import br.com.dev.api.repositories.UserRepository;
import br.com.dev.api.services.UserService;
import br.com.dev.api.services.exceptions.DataIntegrityViolationException;
import br.com.dev.api.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;
    private final UserRepository usuarioRepository;

    public UserServiceImpl(ModelMapper modelMapper, UserRepository usuarioRepository) {
        this.mapper = modelMapper;
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

    @Override
    @Transactional
    public User create(UserDTO userDTO) {
        checkEmailIfPresent(userDTO);
        return usuarioRepository.save(mapper.map(userDTO, User.class));
    }

    @Override
    @Transactional
    public User update(UserDTO userDTO) {
        findById(userDTO.getId());
        checkEmailIfPresent(userDTO);
        return usuarioRepository.save(mapper.map(userDTO, User.class));
    }

    private void checkEmailIfPresent(UserDTO dto) {
        Optional<User> obj = usuarioRepository.findByEmail(dto.getEmail());
        if (obj.isPresent() && !obj.get().getId().equals(dto.getId())) {
            throw new DataIntegrityViolationException("Email " + obj.get().getEmail() + " já cadastrado no sistema!");
        }
    }
}
