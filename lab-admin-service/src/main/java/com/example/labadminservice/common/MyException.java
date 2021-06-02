package com.example.labadminservice.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyException extends RuntimeException{
    private int code;
    public MyException(int code,String msg){
        super(msg);
        this.code = code;
    }
}
