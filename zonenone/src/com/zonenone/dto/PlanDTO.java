package com.zonenone.dto;

import com.zonenone.dao.databeans.Plan;
import com.zonenone.form.PlanFormBean;

public class PlanDTO {

	public Plan fromPlanFormBeanToPlanDBBean(PlanFormBean planFormBean) {
		Plan plan = new Plan();
		plan.setPlanNme(planFormBean.getPlanNme());
		plan.setVoice(Integer.parseInt(planFormBean.getVoice()));
		plan.setText(Integer.parseInt(planFormBean.getText()));
		plan.setData(planFormBean.getData());
		plan.setAmount(Integer.parseInt(planFormBean.getAmt()));
		return plan;
	}

	public void fromPlanDBBeanToPlanFormBean(Plan plan,
			PlanFormBean planFormBean) {
		planFormBean.setId(String.valueOf(plan.getPlanId()));
		planFormBean.setPlanNme(plan.getPlanNme());
		planFormBean.setVoice(String.valueOf(plan.getVoice()));
		planFormBean.setText(String.valueOf(plan.getText()));
		planFormBean.setData(plan.getData());
		planFormBean.setAmt(String.valueOf(plan.getAmount()));
	}

}
