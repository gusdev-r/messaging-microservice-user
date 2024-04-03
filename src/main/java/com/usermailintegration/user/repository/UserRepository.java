package com.usermailintegration.user.repository;

import com.usermailintegration.user.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

}
