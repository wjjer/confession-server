package vip.ablog.api.confession;

import com.jfinal.core.Controller;
import org.apache.commons.lang3.StringUtils;
import vip.ablog.common.model.UserConfession;
import vip.ablog.common.model.base.response.RetMsg;
import vip.ablog.global.SystemConstant;

public class ConfessionController extends Controller {

    ConfessionService confessionService = ConfessionService.me;

    public void getConfession() {
        UserConfession confession = getBean(UserConfession.class);
        String uid = confession.getUid();
        String name = confession.getName();
        RetMsg retMsg = new RetMsg();

        if (StringUtils.isEmpty(uid) || StringUtils.isEmpty(name)) {
            renderJson(new RetMsg(RetMsg.MsgType.ERROR, "用户标识和告白名称不能为空！"));
            return;
        }
        UserConfession userConfession = confessionService.getConfessionByUidAndName(uid, name);
        if (userConfession == null || StringUtils.isEmpty(userConfession.getUrl())) {
            retMsg.setType(RetMsg.MsgType.ERROR);
            retMsg.setMsg("你还没有告白呢！");
            renderJson(retMsg);
        } else {
            int stimes = userConfession.getInt("stimes");
            if (stimes < SystemConstant.NORMAL_USER_MAX_SHARE_TIMES) {

            }
            retMsg.setType(RetMsg.MsgType.SUCCESS);
            retMsg.setBean(userConfession.getUrl());
            renderJson(retMsg);
        }
    }
}
