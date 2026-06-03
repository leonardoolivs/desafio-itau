package br.com.desafioitau.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {

    private LocalDateTime timestamp;
    private Integer status;
    private String error;
    private String path;

    private List<FieldMessage> errors = new ArrayList<>();

    public ApiError(LocalDateTime timestamp, Integer status, String error, String path) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.path = path;
    }

    public void addError(String fieldError, String message){
        errors.add(new FieldMessage(fieldError, message));
    }
}
