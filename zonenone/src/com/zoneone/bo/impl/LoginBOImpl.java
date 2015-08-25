package com.zoneone.bo.impl;

import com.zonenone.bo.BaseBO;
import com.zonenone.form.BaseFormBean;
import com.zonenone.form.LoginFormBean;

public class LoginBOImpl implements BaseBO {

	@Override
	public void load(BaseFormBean baseFormBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(BaseFormBean baseFormBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(BaseFormBean baseFormBean) {
		// TODO Auto-generated method stub

	}

	@Override
	public void validate(BaseFormBean baseFormBean) throws Exception {
		LoginFormBean loginFormBean = (LoginFormBean) baseFormBean;
		if(loginFormBean.getUserName().isEmpty()){
			throw new Exception("Username is required!");
		}
		if(loginFormBean.getPassword().isEmpty()){
			throw new Exception("Password is required!");
		}
		if(!loginFormBean.getUserName().equals("admin") && !loginFormBean.getPassword().equalsIgnoreCase("admin")){
			throw new Exception("Invalid login credentials");
		}

	}

}
