package com.br.riccskn.dto.output;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
        "message",
        "success",
        "result"
})
public class ResponseOutput {

    @JsonProperty(value = "result")
    private Object result;

    @JsonProperty(value = "success")
    private boolean success;

    @JsonProperty(value = "message")
    private String message;

}
