package uk.ac.ncl.csc8499.config;

import com.jfinal.config.*;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.ext.interceptor.SessionInViewInterceptor;
import com.jfinal.ext.plugin.tablebind.AutoTableBindPlugin;
import com.jfinal.ext.plugin.tablebind.SimpleNameStyles;
import com.jfinal.ext.route.AutoBindRoutes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.ehcache.EhCachePlugin;

/**
 * Created by tommy on 2016/5/8.
 */
public class Config extends JFinalConfig {
    @Override
    public void configConstant(Constants me) {
        me.setDevMode(true);
        me.setBaseViewPath("/WEB-INF/views");
//        me.setMaxPostSize(102400000);
        PropKit.use("jdbc.properties");
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new AutoBindRoutes());
    }

    @Override
    public void configPlugin(Plugins me) {

        DruidPlugin dp=new DruidPlugin(PropKit.get("jdbcurl"),PropKit.get("username"),PropKit.get("password"));
        me.add(dp);
        AutoTableBindPlugin atbp = new AutoTableBindPlugin(dp,
                SimpleNameStyles.LOWER_UNDERLINE);
        atbp.setDialect(new MysqlDialect());
        atbp.setShowSql(true);
        atbp.setDevMode(true);
        me.add(atbp);
    }

    @Override
    public void configInterceptor(Interceptors me) {
//        me.add(new AllInterceptor());
        me.add(new TokenInterceptor());
        me.add(new LoginInterceptor());
        me.add(new SessionInViewInterceptor());
    }

    @Override
    public void configHandler(Handlers me) {
        me.add(new ContextPathHandler("context_path"));
    }

    public void main(String[] args){
    }
}
