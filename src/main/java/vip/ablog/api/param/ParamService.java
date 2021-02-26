package vip.ablog.api.param;

import vip.ablog.common.model.Param;

class ParamService {

    static ParamService me = new ParamService();
    private Param dao = new Param().dao();

    Param getParamByKey(String key) {
        return dao.findFirst("select * from `param` where `key` = ?", key);
    }

}
