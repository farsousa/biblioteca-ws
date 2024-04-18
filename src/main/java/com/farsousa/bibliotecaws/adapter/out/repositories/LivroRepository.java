package com.farsousa.bibliotecaws.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.bibliotecaws.adapter.out.entities.LivroEntity;

public interface LivroRepository extends JpaRepository<LivroEntity, Long> {

}
