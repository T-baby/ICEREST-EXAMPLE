package com.cybermkd.config;


import com.cybermkd.plugin.MongoIceRestPlugin;
import com.cybermkd.route.config.*;
import com.cybermkd.route.handler.cors.CORSHandler;

/**
 * 创建人:T-baby
 * 创建日期: 16/8/11
 * 文件描述:
 */
public class AppConfig extends Config {
    /**
     * Config constant
     * 配置常量，目前只能配置render，其他全局配置会自动读取根目录下的application.properties文件，建议用默认
     */
    public void configConstant(ConstantLoader constantLoader) {
        //通过后缀来返回不同的数据类型  你可以自定义自己的 render，一般无需配置
        //如：public class FreemarkerRender extends Render{}
        //目前支持json，text，file三种输出
        //constantLoader.addRender("ftl", new FreemarkerRender());
        constantLoader.setDefaultForward("/"); //单页应用会用到，用来跳过对/的拦截
    }

    /**
     * Config resource
     * 配置Resource路由的扫描目录，ICEREST是自动绑定路由的
     */
    public void configResource(ResourceLoader resourceLoader) {

        resourceLoader.addIncludePackages("com.cybermkd.component");
    }

    /**
     * Config plugin
     * 配置插件
     */
    public void configPlugin(PluginLoader pluginLoader) {

        MongoIceRestPlugin mongoIcePlugin = new MongoIceRestPlugin();

        mongoIcePlugin.add("127.0.0.1", 27017);

        mongoIcePlugin.setDatabase("item");

        pluginLoader.add(mongoIcePlugin);

    }

    /**
     * Config interceptor applied to all actions.
     * 全局拦截，会在进入路由后，执行方法前执前
     */
    public void configInterceptor(InterceptorLoader interceptorLoader) {
        //权限拦截器
        //interceptorLoader.add(new SecurityInterceptor(2, new MyAuthenticateService()));
        //Resource层事务的拦截器 @Transaction
        //interceptorLoader.add(new TransactionInterceptor());
    }

    /**
     * Config handler
     * 全局的拦截，会在进入路由前执行
     */
    public void configHandler(HandlerLoader handlerLoader) {
        //跨域
        handlerLoader.add(new CORSHandler("GET,POST,PUT,DELETE"));
    }


    /**
     * Call back after ICEREST start
     */
    public void afterStart() {
        //ICEREST启动前执行的操作
    }

    /**
     * Call back before ICEREST stop
     */
    public void beforeStop() {
        //ICEREST停止前执行的操作
    }
}
