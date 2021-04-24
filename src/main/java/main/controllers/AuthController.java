package main.controllers;

import main.controllers.responses.UserRequest;
import main.controllers.responses.UserResponse;
import main.entity.User;
import main.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/auth")
    public UserResponse authorize(@RequestBody UserRequest request) {
        User user = userRepository.getByLogin(request.getLogin());

        if (user == null) {
            final String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
            User createdUser = userRepository.save(new User(sessionId, request.getLogin()));
            if (createdUser.getId() != null) {
                return new UserResponse(createdUser.getLogin(), true);
            }
        }

        return new UserResponse(false);
    }

    @GetMapping("/auth")
    public UserResponse authorize() {
        final String sessionId = RequestContextHolder.currentRequestAttributes().getSessionId();
        User user = userRepository.getBySessionId(sessionId);
        if (user != null) {
            return new UserResponse(user.getLogin(), true);

        }
        return new UserResponse(false);
    }

}
