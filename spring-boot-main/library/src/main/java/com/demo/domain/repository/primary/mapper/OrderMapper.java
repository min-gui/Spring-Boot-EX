package com.demo.domain.repository.primary.mapper;

import com.demo.domain.dao.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {

    Order findById(long id);
}
