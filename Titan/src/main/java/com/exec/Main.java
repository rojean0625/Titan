package com.exec;

import java.util.Collection;

import org.drools.core.impl.InternalKnowledgeBase;
import org.drools.core.impl.KnowledgeBaseFactory;
import org.drools.core.marshalling.impl.ProtobufMessages.KnowledgeBase;
import org.kie.api.definition.KiePackage;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.runtime.StatefulKnowledgeSession;

import com.entity.StatisticTrans;
import com.entity.Trans;

public class Main {

	public static void main(String[] args) {
		//String path = Main.class.getClassLoader().getResource("com/exec/Trans.drl").getPath();
		String path = "F:\\workspace-new\\Titan\\src\\main\\resources\\com\\exec\\Trans.drl";
		System.out.println(path);

		StatisticTrans statistic = new StatisticTrans();
		statistic.getTransList().add(new Trans("SEQ01",8000));
		statistic.getTransList().add(new Trans("SEQ02",3000));
		statistic.getTransList().add(new Trans("SEQ03",7000));
		new Main().ini(path,statistic);
	}

	@SuppressWarnings({ "restriction", "restriction"})
	private void ini(String path,StatisticTrans statisticTrans) {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		//
		Resource r = ResourceFactory.newFileResource(path);
		kbuilder.add(r, ResourceType.DRL);
		System.out.println("###");
		if (kbuilder.hasErrors()) {
			System.out.println(kbuilder.getErrors().toString());
		}

		// 存放编译之后规则的对象
		Collection<KiePackage> pkgs = kbuilder.getKnowledgePackages();

		InternalKnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();
		kbase.addPackages(pkgs);
		// StatefulKnowledgeSession ksession =
		// kbase.newStatefulKnowledgeSession();
		KieSession ksession = kbase.newKieSession();
		ksession.insert(statisticTrans);
		ksession.fireAllRules();
		ksession.dispose();
	}

}
