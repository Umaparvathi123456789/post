package com.uma.linkdlen.model;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

	Optional<Post> findById(Long id);

	void deleteById(Long id );



}
