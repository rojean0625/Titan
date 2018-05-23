package com.sample;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.entity.StatisticTrans;
import com.entity.Trans;

public class DroolTrans {

	public static final void main(String[] args){
		KieServices kieService = KieServices.Factory.get();
		KieContainer container = kieService.getKieClasspathContainer();
		KieSession session = container.newKieSession("ksession-specRule");

		StatisticTrans statistic = new StatisticTrans();
		statistic.getTransList().add(new Trans("SEQ01",8000));
		statistic.getTransList().add(new Trans("SEQ02",3000));
		statistic.getTransList().add(new Trans("SEQ03",7000));

		session.insert(statistic);
		session.fireAllRules();
		session.dispose();
		statistic.getRuleResult().forEach(v -> {
			System.out.println("Final SequneNo:"+ v);
		});
	}
}
