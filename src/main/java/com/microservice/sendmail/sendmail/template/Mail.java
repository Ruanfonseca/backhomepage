package com.microservice.sendmail.sendmail.template;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Mail {

    private String nome;
    private String email;
    private String telefone;
    private String mensagem;


}
