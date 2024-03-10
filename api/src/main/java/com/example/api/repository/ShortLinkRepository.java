package com.example.api.repository;

import com.example.api.entity.ShortLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShortLinkRepository extends JpaRepository<ShortLink, Long> {
    Optional<ShortLink> findById(Integer id);



    // Możesz dodać niestandardowe metody repozytorium tutaj, jeśli są potrzebne
}
