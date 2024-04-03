package com.usermailintegration.user.service;

import com.usermailintegration.user.domain.UserModel;
import com.usermailintegration.user.producer.UserProducer;
import com.usermailintegration.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService  {

    private final UserRepository userRepository;
    private final UserProducer userProducer;
    public UserService(UserRepository userRepository, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        userModel = userRepository.save(userModel);
        userProducer.emailMessagePublished(userModel);
        return userModel;
    }
}
