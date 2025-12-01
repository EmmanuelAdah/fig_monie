package com.figmonie.services;

import com.figmonie.data.models.User;
import com.figmonie.data.repositories.UserRepository;
import com.figmonie.dtos.request.RegisterRequest;
import com.figmonie.dtos.responses.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static com.figmonie.utils.Mapper.map;
import static com.figmonie.utils.Validator.isValidRequest;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User saveUser(RegisterRequest request) {
        isValidRequest(request);

        User user = map(request);
        return userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null)
            throw new UsernameNotFoundException("User not found");
        return user;
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserResponse updateImage(String userId, String filePath) {
        return new UserResponse();
    }
}
