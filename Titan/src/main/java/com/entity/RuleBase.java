package com.entity;

import java.util.ArrayList;
import java.util.List;

public class RuleBase {

	public List<String> ruleResult = new ArrayList<String>();

	public List<String> getRuleResult() {
		return ruleResult;
	}

	public void setRuleResult(String ruleResult) {
		this.ruleResult.add(ruleResult);
	}

}
