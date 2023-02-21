package com.techavaliation.cooperativism.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class AssociateDTO {
    
    @NotEmpty(message = "Nome obrigatório")
    @Size(min = 3, max = 20, message = "Nome entre 5 a 30 characteres")
    private String name;

    @NotEmpty(message = "E-mail obrigatório")
    @Email(message = "Exemplo: usuario@gmail.com")
    private String email;

    @NotEmpty(message = "CPF obrigatório")
    private String cpf;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
