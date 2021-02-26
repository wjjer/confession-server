package vip.ablog.api.template;

import com.jfinal.plugin.activerecord.Page;
import vip.ablog.common.model.Param;
import vip.ablog.common.model.SysUser;
import vip.ablog.common.model.Template;

class TemplateService {

    static TemplateService me = new TemplateService();
    private Template dao = new Template().dao();

    public Page<Template> paginate(int pageNumber, int pageSize) {

        String sql = "from template order by create_time desc";
        return dao.paginate(pageNumber, pageSize, "select * ", sql);
    }


}
