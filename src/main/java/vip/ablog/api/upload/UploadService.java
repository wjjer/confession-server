package vip.ablog.api.upload;

import vip.ablog.common.model.Param;

class UploadService {

    static UploadService me = new UploadService();
    private Param dao = new Param().dao();

    Param getParamByKey(String key) {
        return dao.findFirst("select * from param where key = ? limit 1", key);
    }

}
