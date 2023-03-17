package com.evggpa.notarestapi.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class GenericDTO {

    private Map<String, String> camposGenericos = new HashMap<>();


    @JsonAnyGetter
    public Map<String, String> getCamposGenericos() {
        return camposGenericos;
    }

    @JsonAnySetter
    public void setCamposGenericos(String chave, String valor) {
        camposGenericos.put(chave,valor);
    }

    public Boolean encontrouCampo(String chave){
        return camposGenericos.get(chave) == null ? false : true;
    }
}
