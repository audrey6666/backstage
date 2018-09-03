package com.finup.modules.datapi.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ThirdSourceEnum {
    KING_CHAN("jc","金蝉"),
    HONEY_COMB("fc","蜂巢"),
    MO_XIE("mx","魔蝎"),
    KA_NIU("kn","卡牛");

    public String code;
    public String desc;

    private ThirdSourceEnum(String code,String desc){
        this.code=code;
        this.desc=desc;
    }

    public static List convertToList(){
        List list= new ArrayList();
        for (ThirdSourceEnum type : ThirdSourceEnum.values()) {
            Map map = new HashMap();
            map.put("code",type.code);
            map.put("desc",type.desc);
            list.add(map);
        }
        return list;
    }

    public static String getDescByCode(String code){
        for (ThirdSourceEnum type : ThirdSourceEnum.values()) {
           if(type.code.equals(code)){
               return type.desc;
           }
        }
        return null;
    }

}
