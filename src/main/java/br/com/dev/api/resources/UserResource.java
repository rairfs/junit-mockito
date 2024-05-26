package br.com.dev.api.resources;

import br.com.dev.api.domain.User;
import br.com.dev.api.domain.dto.UserDTO;
import br.com.dev.api.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResource {

    private final ModelMapper mapper;
    private final UserService userService;

    public UserResource(ModelMapper mapper, UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(userService.findById(id), UserDTO.class));
    }
}
