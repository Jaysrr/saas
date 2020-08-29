package com.saas.response;

import com.saas.vo.GoodsVo;
import lombok.Data;

import java.util.List;

/**
 * @program: saas
 * @description:
 * @author: Jaysrr
 * @create: 2020-08-29 17:22
 **/
@Data
public class FindAllGoodsResponse {
    private List<GoodsVo> goodsVoList;

    private Long total;
}
