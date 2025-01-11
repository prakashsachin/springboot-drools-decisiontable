package com.drools.example.config;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.ReleaseId;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DroolConfig {

	private final KieServices kieServices = KieServices.Factory.get();

	private KieFileSystem getKieFileSystem() {
		KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		List<String> rules = List.of("rules/eligibility_rules.drl.xls");
		rules.stream().map(ResourceFactory::newClassPathResource).forEach(kieFileSystem::write);
		//when only one rule file needs to be loaded we dont need to use stream and below code be used
		//kieFileSystem.write(ResourceFactory.newClassPathResource("rules/eligibility_rules.drl.xls"));
		return kieFileSystem;
	}

	@Bean
	public KieContainer getKieContainer() {
		KieBuilder kb = kieServices.newKieBuilder(getKieFileSystem());
		kb.buildAll();
		KieRepository kieRepository = kieServices.getRepository();
		ReleaseId krDefaultReleaseId = kieRepository.getDefaultReleaseId();
		return kieServices.newKieContainer(krDefaultReleaseId);
	}

	@Bean
	public KieSession getKieSession(){
		//session created
		return getKieContainer().newKieSession();

	}

}
