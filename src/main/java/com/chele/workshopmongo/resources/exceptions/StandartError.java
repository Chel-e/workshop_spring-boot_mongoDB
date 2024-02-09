package com.chele.workshopmongo.resources.exceptions;

import java.io.Serializable;

public record StandartError(Long timestamp, Integer status, String Error, String message, String path) implements Serializable{
    
}
