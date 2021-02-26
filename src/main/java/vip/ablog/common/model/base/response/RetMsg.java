package vip.ablog.common.model.base.response;

import java.io.Serializable;

/**
 * ajax请求的时候，返回给前端的消息体，前端会根据消息信息作出相关响应
 * @author liuwt
 *
 */
public class RetMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	/*消息类型*/
	public interface MsgType {
		static String SUCCESS ="success";//成功
		static String WARING ="warning";//警告
		static String ERROR ="error";//错误
		static String INFO ="info";//消息
		static String TOLOGIN="tologin";//跳转到登录页面
		static String RELOAD="reload";//刷新
	}

	private String type = MsgType.SUCCESS;//消息类型
	private boolean show = true;//是否自动弹框显示
	private Object msg;//消息体
	private String title;//标题
	private int time = -1;// 显示时间

	private Object bean;//可选业务对象  在返回对象同时需要把 操作失败的原因 反馈给用户进行调整后再操作时  才用， 其它大多情况无需使用这个属性

	public RetMsg(){
		super();
	}

	public RetMsg(String type, Object msg) {
		super();
		this.type = type;
		this.msg = msg;
	}

	public RetMsg(String type, boolean show, Object msg, Object bean) {
		super();
		this.type = type;
		this.show = show;
		this.msg = msg;
		this.bean = bean;
	}

	public RetMsg(String type, boolean show, Object msg) {
		super();
		this.type = type;
		this.show = show;
		this.msg = msg;
	}

	public RetMsg(String type, boolean show, Object msg, int time) {
		super();
		this.type = type;
		this.show = show;
		this.msg = msg;
		this.time = time;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Object getMsg() {
		return msg;
	}
	public void setMsg(Object msg) {
		this.msg = msg;
	}

	public Object getBean() {
		return bean;
	}

	public void setBean(Object bean) {
		this.bean = bean;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}


}
