package com.seuprojeto.gerencia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegistroRequest {

    @NotBlank(message = "O nome e obrigatorio.")
    private String nome;

    @Email(message = "Informe um e-mail valido.")
    @NotBlank(message = "O e-mail e obrigatorio.")
    private String email;

    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres.")
    @NotBlank(message = "A senha e obrigatoria.")
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
