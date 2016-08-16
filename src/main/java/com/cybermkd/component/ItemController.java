package com.cybermkd.component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.cybermkd.common.http.result.HttpStatus;
import com.cybermkd.common.http.result.WebResult;
import com.cybermkd.route.annotation.*;
import com.cybermkd.route.core.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/11
 * 文件描述:
 */

@API("/v1/item")
public class ItemController extends Resource {

    ItemModel m = new ItemModel();

    @GET()
    public WebResult get() {
        return render(m.get());
    }

    @POST(valid = {ContentValidator.class})
    public WebResult post() {
        ItemBean bean = getParams().getObject(ItemBean.class);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        bean.setCreat_time(df.format(new Date()));
        return render(m.save(bean));
    }

    @PUT(valid = {IdValidator.class, ContentValidator.class})
    public WebResult put() {
        return render(m.put(getParams().getObject(ItemBean.class)));
    }

    @DELETE(valid = {IdValidator.class})
    public WebResult delete() {
        return render(m.delete(getParams().getObject(ItemBean.class)));
    }

    private WebResult render(Object obj) {
        JSONObject json = new JSONObject();
        json.put("result", obj);
        return new WebResult(HttpStatus.OK, JSON.toJSONString(json));
    }


}
