package com.cybermkd.component;

import com.cybermkd.route.core.Params;
import com.cybermkd.route.core.RouteMatch;
import com.cybermkd.route.valid.ValidResult;
import com.cybermkd.route.valid.Validator;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/12
 * 文件描述:
 */
public class IdValidator extends Validator {
    @Override
    public ValidResult validate(Params params, RouteMatch routeMatch) {
        ItemBean item = params.getObject(ItemBean.class);

        ValidResult result = new ValidResult();


        result.mongoValid(item, "id");

        if (result.isError()) {
            return result;
        }

        ItemModel m = new ItemModel();

        try {
            if (m.get(params.get("id")).isEmpty()) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            result.addError("error", "100");
            result.addError("errorMessage", "id is error.");
        }

        return result;

    }
}
