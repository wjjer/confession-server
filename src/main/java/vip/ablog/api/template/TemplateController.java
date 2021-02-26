package vip.ablog.api.template;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import vip.ablog.common.model.Template;

public class TemplateController extends Controller {

    TemplateService templateService = TemplateService.me;

    public void findTemplateList() {
        Integer pageNo = Integer.valueOf(getKv().getStr("pageNo"));
        Integer limit =  Integer.valueOf(getKv().getStr("limit"));
        if (pageNo <= 1) {
            pageNo = 1;
        }
        if (limit <= 0) {
            return;
        }
        Page<Template> templatePage = templateService.paginate(pageNo, limit);
        renderJson(templatePage.getList());
    }
}
