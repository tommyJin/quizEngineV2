package uk.ac.ncl.csc8499.controller;

import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.Restful;
import com.jfinal.ext.route.ControllerBind;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.ConstantParas;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tommy on 2016/5/27.
 */
@ControllerBind(controllerKey = "/token")
public class TokenController extends Controller {
    public void tokenInvalid(){
        Map<String,Object> map = new HashMap<>();
        map.put("errmsg",ConstantParas.token_invalid_message);
        map.put("code", ConstantParas.token_invalid);
        renderJson(RestResult.error(map));
    }


}
