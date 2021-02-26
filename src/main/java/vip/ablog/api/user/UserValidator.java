package vip.ablog.api.user;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;

public class UserValidator extends Validator {
    @Override
    protected void validate(Controller controller) {
        //validateRequiredString("user.title", "titleMsg", "请输入Blog标题!");
        //validateRequiredString("user.content", "contentMsg", "请输入Blog内容!");
    }

    @Override
    protected void handleError(Controller controller) {
       // controller.keepModel(Blog.class);
    }
}
