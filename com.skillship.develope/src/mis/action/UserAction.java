package mis.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import mis.dao.UserDAO;
import mis.entity.user;
@SuppressWarnings("serial")
@Results({
		@Result(name = "list", location = "/test/test.jsp")	

})
public class UserAction extends ActionSupport {

	private List<user> ulist;
	private user entity;
	@Autowired
	private UserDAO d;
	
	 public String list() throws Exception{
		  
		 ulist= d.listall();
		  System.out.println("--"+ulist.get(1));
		  return "list";
	  }

	 
	 
	 
	 
	 
	 
	public List<user> getUlist() {
		return ulist;
	}

	public void setUlist(List<user> ulist) {
		this.ulist = ulist;
	}

	public user getEntity() {
		return entity;
	}

	public void setEntity(user entity) {
		this.entity = entity;
	}
}
