package com.otaku.bot.repositories;

import com.otaku.bot.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {}
