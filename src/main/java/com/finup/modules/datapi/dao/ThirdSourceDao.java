package com.finup.modules.datapi.dao;

import com.finup.modules.datapi.entity.ThirdSourceEntity;
import com.finup.modules.datapi.enums.ThirdSourceEnum;
import com.finup.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 三方数据配置
 */
@Mapper
public interface ThirdSourceDao extends BaseDao<ThirdSourceEntity> {

    public ThirdSourceEntity queryThirdSource(String creditType);

}
