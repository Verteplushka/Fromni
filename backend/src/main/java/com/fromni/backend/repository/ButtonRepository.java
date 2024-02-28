package com.fromni.backend.repository;

import com.fromni.backend.entity.Button;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ButtonRepository extends JpaRepository<Button, Long> {
    Optional<List<Button>> findAllByMessageId(Long messageId);
}
