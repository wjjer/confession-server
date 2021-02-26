package vip.ablog.api.user;


import com.alibaba.druid.util.StringUtils;
import com.jfinal.core.Controller;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.JsonKit;
import com.jfinal.kit.Kv;
import vip.ablog.common.model.SysUser;
import vip.ablog.common.model.base.response.RetMsg;
import vip.ablog.global.SystemConstant;
import vip.ablog.utils.DateUtils;

public class UserController extends Controller {


    UserService service = UserService.me;

    public void register() {
        SysUser sysUser = getBean(SysUser.class);
        RetMsg retMsg = new RetMsg();
        if (StringUtils.isEmpty(sysUser.getStr("email")) || StringUtils.isEmpty(sysUser.getStr("passwd"))) {
            retMsg.setMsg("邮箱号不能为空");
            retMsg.setType(RetMsg.MsgType.ERROR);
            renderJson(retMsg);
            return;
        }

        SysUser sysUserByEmail = service.findByEmail(sysUser.getStr("email"));
        if (sysUserByEmail != null && sysUserByEmail.getStr("email") != null) {
            retMsg.setMsg("该邮箱已经注册过");
            retMsg.setType(RetMsg.MsgType.ERROR);
            renderJson(retMsg);
            return;
        }

        sysUser.set("create_time", DateUtils.getDateTime());
        sysUser.set("vip", SystemConstant.NO_VIP);
        sysUser.set("dtimes",0);
        sysUser.save();
        retMsg.setType(RetMsg.MsgType.SUCCESS);
        retMsg.setBean(sysUser);
        retMsg.setMsg("注册成功");
        renderJson(retMsg);
    }


    public void login() {
        SysUser sysUser = getBean(SysUser.class);
        RetMsg retMsg = new RetMsg();
        if (StringUtils.isEmpty(sysUser.getStr("email")) || StringUtils.isEmpty(sysUser.getStr("passwd"))) {
            retMsg.setMsg("邮箱号/密码不能为空");
            retMsg.setType(RetMsg.MsgType.ERROR);
            renderJson(retMsg);
            return;
        }

        SysUser sysUserByEmail = service.findByEmail(sysUser.getStr("email"));
        if (sysUserByEmail == null || sysUserByEmail.getStr("email") == null) {
            retMsg.setMsg("您还未注册");
            retMsg.setType(RetMsg.MsgType.ERROR);
            renderJson(retMsg);
            return;
        }
        if (!sysUser.getStr("passwd").equals(sysUserByEmail.getStr("passwd"))) {
            retMsg.setMsg("登陆密码输入错误");
            retMsg.setType(RetMsg.MsgType.ERROR);
            renderJson(retMsg);
            return;
        }

        retMsg.setType(RetMsg.MsgType.SUCCESS);
        retMsg.setBean(sysUserByEmail);
        retMsg.setMsg("登录成功");
        renderJson(retMsg);
    }
}
