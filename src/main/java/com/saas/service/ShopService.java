package com.saas.service;

import com.saas.request.*;
import com.saas.response.IntegerResultResponse;
import com.saas.response.ShopLoginResponse;
import com.saas.response.UserLoginResponse;

public interface ShopService {
    IntegerResultResponse addShop(AddShopRequest request);

    IntegerResultResponse updateShop(UpdateShopRequest request);

    ShopLoginResponse login(ShopLoginRequest request);
}
