package uk.ac.ncl.csc8499.controller;

import com.google.gson.Gson;
import com.jfinal.core.Controller;
import com.jfinal.ext.route.ControllerBind;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.ac.ncl.csc8499.Util.RestResult;
import uk.ac.ncl.csc8499.model.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tommy on 2016/5/8.
 */
@ControllerBind(controllerKey = "/")
public class IndexController extends Controller {
    static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    static final String tag = "index";
    Gson gson = new Gson();

    public void index(){
        redirect("/route/login");
    }

}
