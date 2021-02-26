package vip.ablog.api.upload;

import com.jfinal.core.Controller;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.PathKit;
import com.jfinal.upload.UploadFile;
import org.apache.commons.lang3.StringUtils;
import vip.ablog.api.confession.ConfessionService;
import vip.ablog.api.user.UserService;
import vip.ablog.common.model.SysUser;
import vip.ablog.common.model.UserConfession;
import vip.ablog.common.model.base.response.RetMsg;
import vip.ablog.global.SystemConstant;
import vip.ablog.utils.DateUtils;
import vip.ablog.utils.ZipUtil;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

public class UploadController extends Controller {

    ConfessionService confessionService = ConfessionService.me;
    UserService userService = UserService.me;

    public void uploadConfession() throws UnsupportedEncodingException {

        UploadFile uploadFile = getFile();
        String email = getPara("email");
        RetMsg retMsg = new RetMsg();
        if (email.isEmpty()) {
            retMsg.setType(RetMsg.MsgType.ERROR);
            retMsg.setMsg("用户信息为空,不允许分享！");
            renderJson(retMsg);
            return;
        }

        if (uploadFile != null) {
            //上传文件路径
            String uploadPath = PathKit.getWebRootPath() + File.separator + "upload";
            LogKit.debug("文件上传：" + uploadPath + " email: " + email);
            //上传文件名
            String uploadFileName = uploadFile.getOriginalFileName();
            String uploadFileType = uploadFileName.substring(uploadFileName.lastIndexOf("."));
            String originFileName = uploadFileName.substring(0, uploadFileName.lastIndexOf("."));

            //判断
            UserConfession confession = confessionService.getConfessionByUidAndName(email, originFileName);
            if (confession != null && StringUtils.isNotEmpty(confession.getUrl())) {
                retMsg.setType(RetMsg.MsgType.SUCCESS);
                retMsg.setBean(confession.getUrl());
                renderJson(retMsg);
                return;
            }

            SysUser user = userService.findByEmail(email);
            if (user != null && user.getId() != 0) {
                int vip = user.getVip();
                int dtimes = user.getDtimes();
                user.setDtimes(++dtimes);
                user.update();
            }

            String fileName = UUID.randomUUID().toString();
            File filePath = new File(uploadPath, uploadFileName);
            //判断路径是否存在，如果不存在就创建一个
            if (!filePath.getParentFile().exists()) {
                filePath.getParentFile().mkdirs();
            }
            String saveFile = uploadPath + File.separator + fileName + "." + uploadFileType;
            File file = new File(saveFile);
            if (file.exists()) {
                file.delete();
            }
            // 上传文件到指定位置
            uploadFile.getFile().renameTo(file);
            uploadFile.getFile().delete();
            boolean result = deployPage(saveFile, SystemConstant.TARGET_PATH + File.separator + email);
            if (result) {
                //存储告白
                String urlName = null;
                urlName = URLEncoder.encode(originFileName, "UTF-8");
                String url = email + File.separator + urlName;
                if (confession != null) {
                    confession.setStimes(confession.getLong("stimes") + 1);
                } else {
                    confession = new UserConfession();
                    confession.setUid(email);
                    confession.setStimes(1L);
                    confession.setName(originFileName);
                }
                confession.setUrl(url);
                confession.setCreateTime(DateUtils.getDate());
                confession.save();
                retMsg.setType(RetMsg.MsgType.SUCCESS);
                retMsg.setMsg("部署成功");
                retMsg.setBean(url);
                renderJson(retMsg);
            } else {
                retMsg.setType(RetMsg.MsgType.ERROR);
                retMsg.setBean("页面部署失败！");
               renderJson(retMsg);
            }
        } else {
            retMsg.setType(RetMsg.MsgType.ERROR);
            retMsg.setBean("上传文件失败");
            renderJson(retMsg);
        }
    }

    private boolean deployPage(String saveFile, String targetPath) {
        return ZipUtil.upZipFile(saveFile, targetPath + File.separator);
    }
}
