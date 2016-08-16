package com.cybermkd.component;

import com.cybermkd.route.core.Params;
import com.cybermkd.route.core.RouteMatch;
import com.cybermkd.route.valid.ValidResult;
import com.cybermkd.route.valid.Validator;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/11
 * 文件描述:
 */
public class ContentValidator extends Validator {
    @Override
    public ValidResult validate(Params params, RouteMatch routeMatch) {

        ItemBean item = params.getObject(ItemBean.class);

        return new ValidResult().mongoValid(item, "content");
    }
}
