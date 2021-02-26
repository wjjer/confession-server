package vip.ablog.api.param;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.Kv;
import vip.ablog.common.model.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class ParamController extends Controller {

    ParamService service = ParamService.me;

    public void getParamByKey() {
        String key = (String) getKv().get("key");
        Param para = service.getParamByKey(key);
        renderJson(para);
    }
}
