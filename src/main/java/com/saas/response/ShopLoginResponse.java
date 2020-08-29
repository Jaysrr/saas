package com.saas.response;

import com.saas.dto.ShopDto;
import com.saas.pojo.Shop;
import lombok.Data;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-16 20:39
 **/
@Data
public class ShopLoginResponse {
    private ShopDto shopDto;

    private String token;
}
