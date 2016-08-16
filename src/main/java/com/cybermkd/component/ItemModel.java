package com.cybermkd.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cybermkd.kit.MongoQuery;

import java.util.List;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/12
 * 文件描述:
 */
public class ItemModel {

    private static String collectionName = "storehouse";

    public List<JSONObject> get() {
        return new MongoQuery().use(collectionName).findAll();
    }

    public List<JSONObject> get(String id) {
        return new MongoQuery().use(collectionName).byId(id).find();
    }

    public boolean save(ItemBean bean) {
        System.out.println(JSON.toJSONString(bean));
        bean.setId(null);  //以免万一清空id
        return new MongoQuery().use(collectionName).set(bean).save() > 0;
    }

    public boolean put(ItemBean bean) {
        MongoQuery query = new MongoQuery().use(collectionName).byId(bean.getId());
        /*因为在controller是直接获取整个对象的(在查询的时候为了大家方便会自动将_id变为id,但是mongodb实际存的还是_id),
        / 为了避免将id插入进去,特意清空。*/
        bean.setId(null);
        return query.modify(bean).update() > 0;
    }

    public boolean delete(ItemBean bean) {
        return new MongoQuery().use(collectionName).byId(bean.getId()).delete() > 0;
    }

}
