package vip.ablog.api.user;

import com.jfinal.plugin.activerecord.Page;
import vip.ablog.common.model.SysUser;

public class UserService {

    public static UserService me = new UserService();
    private SysUser dao = new SysUser().dao();

	public Page<SysUser> paginate(int pageNumber, int pageSize) {
		return dao.paginate(pageNumber, pageSize, "select *", "from sys_user order by id asc");
	}

	public SysUser findByEmail(String email) {
		return dao.findFirst("select * from sys_user where email = ? order by create_time asc",email);
	}

	public SysUser findById(int id) {
		return dao.findById(id);
	}

	public void deleteById(int id) {
		dao.deleteById(id);
	}
}
