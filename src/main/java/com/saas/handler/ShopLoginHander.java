package com.saas.handler;

public interface ShopLoginHander {
    boolean loginCheck(Long shopId, String token);
}
