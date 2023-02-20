package com.techavaliation.cooperativism.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class ScheduleDTO {

    @NotEmpty(message = "Conteudo da pauta necessária")
    @Size(min = 3, max = 20, message = "Pequena descrição entre 3 a 20 characteres")
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
