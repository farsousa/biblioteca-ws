package com.farsousa.bibliotecaws.adapter.out.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farsousa.bibliotecaws.adapter.out.entities.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
