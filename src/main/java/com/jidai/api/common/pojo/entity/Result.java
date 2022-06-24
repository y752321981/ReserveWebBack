package com.jidai.api.common.pojo.entity;

import com.jidai.api.common.pojo.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<E> implements Serializable {
    private String code;
    private String message;
    private E data;
    public static <E> Result<E> success(E object) {
        return new Result<E>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), object);
    }

    public static Result success() {
        return success(new Object());
    }
}
