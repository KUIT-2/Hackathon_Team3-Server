package com.example.catchtable.service;

import com.example.catchtable.dto.user.PostUserRequest;
import com.example.catchtable.dto.user.PostUserResponse;
import com.example.catchtable.model.User;
import com.example.catchtable.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public PostUserResponse saveUser(PostUserRequest postUserRequest) {
        User user = userRepository.save(
                new User(
                        postUserRequest.getName(),
                        postUserRequest.getIntroduction(),
                        postUserRequest.getRegion()
                )
        );

        return new PostUserResponse(user.getUserId());
    }
}
