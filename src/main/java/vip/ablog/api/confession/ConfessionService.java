package vip.ablog.api.confession;

import vip.ablog.api.user.UserService;
import vip.ablog.common.model.UserConfession;

public class ConfessionService {


    public static ConfessionService me = new ConfessionService();
    private UserConfession dao = new UserConfession().dao();

    UserConfession getParamByKey(String key) {
        return dao.findFirst("select * from param where key = ? limit 1", key);
    }

    public UserConfession getConfessionByUidAndName(String email, String originFileName) {
        return dao.findFirst("select * from user_confession where uid = ? and name = ?", email, originFileName);
    }
}
