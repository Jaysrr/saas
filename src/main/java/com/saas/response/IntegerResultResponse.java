package com.saas.response;

import lombok.Data;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 10:35
 **/
@Data
public class IntegerResultResponse {
    private Integer result;

    public IntegerResultResponse(Integer result) {
        this.result = result;
    }
}
