package com.example.demo.mapper;

import com.example.demo.entity.Supplier;
import org.apache.ibatis.annotations.Param;

/**
 * @author jingzhidematong
 * @date 2019/11/29
 */
public interface SupplierMapper {

    Supplier selectSupplier(@Param("supplierId") String supplierId);
}
