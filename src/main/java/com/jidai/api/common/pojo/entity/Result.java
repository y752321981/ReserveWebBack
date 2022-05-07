package com.jidai.api.common.pojo.entity;

import com.jidai.api.common.pojo.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<E> implements Serializable {
    private Integer code;
    private String message;
    private E data;
    public static <E> Result<E> success(E object) {
        return new Result<E>(ResultCodeEnum.success.ordinal(), null, object);
    }
}
