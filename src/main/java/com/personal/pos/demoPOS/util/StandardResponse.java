package com.personal.pos.demoPOS.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StandardResponse {
    private int code; // http response code ==>>>>
    private String message;
    private Object data;

}
