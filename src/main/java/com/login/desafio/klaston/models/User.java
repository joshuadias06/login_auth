package com.login.desafio.klaston.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Retorna o papel do usuário (por exemplo, "USER", "ADMIN", etc.)
        return List.of(() -> "ROLE_USER");  // Exemplo simples de papel fixo
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Conta nunca expira
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Conta não é bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Credenciais nunca expiram
    }

    @Override
    public boolean isEnabled() {
        return true; // Conta está habilitada
    }
}