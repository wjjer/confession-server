package vip.ablog.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseUserConfession<M extends BaseUserConfession<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public java.lang.Integer getId() {
		return getInt("id");
	}
	
	public M setUid(java.lang.String uid) {
		set("uid", uid);
		return (M)this;
	}
	
	public java.lang.String getUid() {
		return getStr("uid");
	}
	
	public M setName(java.lang.String name) {
		set("name", name);
		return (M)this;
	}
	
	public java.lang.String getName() {
		return getStr("name");
	}
	
	public M setUrl(java.lang.String url) {
		set("url", url);
		return (M)this;
	}
	
	public java.lang.String getUrl() {
		return getStr("url");
	}
	
	public M setStimes(java.lang.Long stimes) {
		set("stimes", stimes);
		return (M)this;
	}
	
	public java.lang.Long getStimes() {
		return getLong("stimes");
	}
	
	public M setCreateTime(java.lang.String createTime) {
		set("create_time", createTime);
		return (M)this;
	}
	
	public java.lang.String getCreateTime() {
		return getStr("create_time");
	}
	
}
