package com.finup.modules.datapi.service.impl;

import com.finup.modules.datapi.dao.ThirdSourceDao;
import com.finup.modules.datapi.entity.ThirdSourceEntity;
import com.finup.modules.datapi.enums.ThirdSourceEnum;
import com.finup.modules.datapi.service.ThirdSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 三方数据源管理
 */
@Service("thirdSourceService")
public class ThirdSourceServiceImpl implements ThirdSourceService{

    @Autowired
    private ThirdSourceDao thirdSourceDao;

    @Override
    public List<ThirdSourceEntity> queryList(Map<String, Object> map) {
        return thirdSourceDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return thirdSourceDao.queryTotal(map);
    }

    @Override
    public ThirdSourceEntity queryObject(Long id) {
        return thirdSourceDao.queryObject(id);
    }

    @Override
    public void update(ThirdSourceEntity thirdSourceEntity) {
        thirdSourceDao.update(thirdSourceEntity);
    }

    /**
     * 根据授信项类型获取渠道编号
     * @param creditType
     * @return
     */
    @Override
    public String queryThirdSource(String creditType) {
        ThirdSourceEntity thirdSourceEntity = thirdSourceDao.queryThirdSource(creditType);
        if(thirdSourceEntity!=null){
            return thirdSourceEntity.getThirdSource();
        }else{
            //为空返回默认数据派
            return ThirdSourceEnum.KING_CHAN.code;
        }
    }


}
