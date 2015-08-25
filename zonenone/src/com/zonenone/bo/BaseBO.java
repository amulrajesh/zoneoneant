package com.zonenone.bo;

import com.zonenone.form.BaseFormBean;

public interface BaseBO {
	
	public void load(BaseFormBean baseFormBean);
	
	public void save(BaseFormBean baseFormBean);
	
	public void delete(BaseFormBean baseFormBean);
	
	public void validate(BaseFormBean baseFormBean) throws Exception;

}
