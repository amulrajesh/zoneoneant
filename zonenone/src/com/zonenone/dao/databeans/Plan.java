package com.zonenone.dao.databeans;

public class Plan {
	
	private int planId;
	
	private String planNme;
	
	private int voice;
	
	private int text;
	
	private String data;
	
	private int amount;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanNme() {
		return planNme;
	}

	public void setPlanNme(String planNme) {
		this.planNme = planNme;
	}

	public int getVoice() {
		return voice;
	}

	public void setVoice(int voice) {
		this.voice = voice;
	}

	public int getText() {
		return text;
	}

	public void setText(int text) {
		this.text = text;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
