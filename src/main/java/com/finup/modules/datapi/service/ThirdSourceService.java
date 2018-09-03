package com.finup.modules.datapi.service;

import com.finup.modules.datapi.entity.ThirdSourceEntity;

import java.util.List;
import java.util.Map;

/**
 * 第三方数据源管理
 */
public interface ThirdSourceService {

    public List<ThirdSourceEntity> queryList(Map<String, Object> map) ;

    public int queryTotal(Map<String, Object> map);

    public ThirdSourceEntity queryObject(Long id);

    public void update(ThirdSourceEntity thirdSourceEntity);

    public String queryThirdSource(String creditType);


}
