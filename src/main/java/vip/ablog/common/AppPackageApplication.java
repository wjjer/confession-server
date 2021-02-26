package vip.ablog.common;

import com.jfinal.core.JFinal;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.StrKit;
import vip.ablog.utils.ZipUtil;

public class AppPackageApplication {
    /**
     * 用于在 IDEA 中，通过创建 main 方法的方式启动项目，不支持热加载
     * 本方法存在的意义在于此方法启动的速度比 maven 下的 jetty 插件要快得多
     * <p>
     * 注意：不支持热加载。建议通过 Ctrl + F5 快捷键，来快速重新启动项目，速度并不会比 eclipse 下的热加载慢多少
     * 实际操作中是先通过按 Alt + 5 打开 debug 窗口，才能按 Ctrl + F5 重启项目
     */
    public static void main(String[] args) {
        /**
         * 特别注意：IDEA 之下建议的启动方式，仅比 eclipse 之下少了最后一个参数
         */
        String baseBath = String.valueOf(AppPackageApplication.class.getProtectionDomain().getCodeSource().getLocation());
        String classPath, webRootPath, jarPath;
        if (StrKit.notBlank(baseBath) && baseBath.contains("file:/")) {
            // 获取运行操作系统的运行方式  window和linux的细微区别
            boolean windows = System.getProperties().getProperty("os.name").contains("Windows");
            System.out.println(System.getProperties().getProperty("os.name"));
            jarPath = (windows ? "" : "/") + baseBath.substring("file:/".length());
            classPath = (windows ? "" : "/") + jarPath.substring(0, jarPath.lastIndexOf("/")) + "/class-path";
            System.out.println("jarPath:" + jarPath);
            System.out.println("classPath:" + classPath);
            webRootPath = classPath;
            ZipUtil.upZipFile(jarPath, classPath);
            // 这两步是核心指定 webapp目录和classpath目录
            PathKit.setWebRootPath(webRootPath);
            PathKit.setRootClassPath(classPath);
            // eclipse 启动是4个参数
            JFinal.start(webRootPath, 8080, "/");
        } else {
            throw new RuntimeException("你的路径不对!");
        }
    }
}
