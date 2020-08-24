package com.saas.common;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;
/**
 * @Description: 这是tk.mybatis的commonMapper
 */
public interface CommonMapper<T>  extends Mapper<T>, MySqlMapper<T> {
}
