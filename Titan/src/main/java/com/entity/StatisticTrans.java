package com.entity;

import java.util.ArrayList;
import java.util.List;

public class StatisticTrans extends RuleBase {

	List<Trans> transList = new ArrayList<Trans>();

	public List<Trans> getTransList() {
		return transList;
	}

	public void setTransList(List<Trans> transList) {
		this.transList = transList;
	}


}
