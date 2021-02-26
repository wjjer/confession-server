package vip.ablog.common;

import com.jfinal.json.FastJsonFactory;
import vip.ablog.api.confession.ConfessionController;
import vip.ablog.api.param.ParamController;
import vip.ablog.api.template.TemplateController;
import vip.ablog.api.upload.UploadController;
import vip.ablog.api.user.UserController;
import vip.ablog.common.model._MappingKit;
import vip.ablog.index.IndexController;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class AppApplication extends JFinalConfig {

    /**
     * 运行此 main 方法可以启动项目，此main方法可以放置在任意的Class类定义中，不一定要放于此
     * <p>
     * 使用本方法启动过第一次以后，会在开发工具的 debug、run config 中自动生成
     * 一条启动配置，可对该自动生成的配置再添加额外的配置项，例如 VM argument 可配置为：
     * -XX:PermSize=64M -XX:MaxPermSize=256M
     */
    public static void main(String[] args) {
        JFinal.start("src/main/resources", 80, "/");
    }

    /**
     * 配置常量
     */
    @Override
    public void configConstant(Constants me) {
        // 加载少量必要配置，随后可用PropKit.get(...)获取值
        me.setEncoding("utf-8");
        //限制文件大小为 10MB
        me.setMaxPostSize(10 * 1024 * 1024);
        PropKit.use("a_little_config.txt");
        me.setDevMode(PropKit.getBoolean("devMode", false));
        me.setJsonFactory(new FastJsonFactory());


    }

    /**
     * 配置路由
     */
    @Override
    public void configRoute(Routes me) {
        // 第三个参数为该Controller的视图存放路径
        me.add("/", IndexController.class, "/index");
        // 第三个参数省略时默认与第一个参数值相同，在此即为 "/user"
        me.add("/user", UserController.class);
        me.add("/upload", UploadController.class);
        me.add("/param", ParamController.class);
        me.add("/confession", ConfessionController.class);
        me.add("/template", TemplateController.class);
    }

    @Override
    public void configEngine(Engine me) {}

    /**
     * 配置插件
     */
    @Override
    public void configPlugin(Plugins me) {
        // 配置 druid 数据库连接池插件
        DruidPlugin druidPlugin = new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
        me.add(druidPlugin);

        // 配置ActiveRecord插件
        ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
        // 所有映射在 MappingKit 中自动化搞定
        _MappingKit.mapping(arp);
        me.add(arp);
    }

    public static DruidPlugin createDruidPlugin() {
        return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
    }

    /**
     * 配置全局拦截器
     */
    @Override
    public void configInterceptor(Interceptors me) {

    }

    /**
     * 配置处理器
     */
    @Override
    public void configHandler(Handlers me) {

    }
}
