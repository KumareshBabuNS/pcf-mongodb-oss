package org.springframework.cloud.servicebroker.mongodb.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.cloud.servicebroker.model.Catalog;
import org.springframework.cloud.servicebroker.model.Plan;
import org.springframework.cloud.servicebroker.model.ServiceDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfig {
	
	@Bean
	public Catalog catalog() {
		return new Catalog(Collections.singletonList(
				new ServiceDefinition(
						"mongodb-service-broker",
						"MongoDB",
						"MongoDB service broker implementation for Community Edition",
						true,
						true,
						Collections.singletonList(
								new Plan("mongo-plan",
										"Default Mongo Plan",
										"This is a default mongo plan.  All services are created equally.",
										getPlanMetadata())),
						Arrays.asList("mongodb", "document"),
						getServiceDefinitionMetadata(),
						null,
						null)));
	}
	
/* Used by Pivotal CF console */

	private Map<String, Object> getServiceDefinitionMetadata() {
		Map<String, Object> sdMetadata = new HashMap<>();
		sdMetadata.put("displayName", "MongoDB");
		//sdMetadata.put("imageUrl", "http://info.mongodb.com/rs/mongodb/images/MongoDB_Logo_Full.png");
                sdMetadata.put("imageUrl", "data:image/png;base64,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");
		sdMetadata.put("longDescription", "MongoDB Service");
		sdMetadata.put("providerDisplayName", "Pivotal");
		sdMetadata.put("documentationUrl", "https://github.com/spring-cloud-samples/cloudfoundry-mongodb-service-broker");
		sdMetadata.put("supportUrl", "https://github.com/spring-cloud-samples/cloudfoundry-mongodb-service-broker");
		return sdMetadata;
	}
	
	private Map<String,Object> getPlanMetadata() {
		Map<String, Object> planMetadata = new HashMap<>();
		planMetadata.put("costs", getCosts());
		planMetadata.put("bullets", getBullets());


		return planMetadata;
	}

	private List<Map<String,Object>> getCosts()
		{
		Map<String,Object> costsMap = new HashMap<>();
		
		Map<String,Object> amount = new HashMap<>();
		amount.put("usd", 0.0);
	
		costsMap.put("amount", amount);
		costsMap.put("unit", "MONTHLY");

		List costMapList = Collections.singletonList(costsMap);
		return costMapList;
		}
	
	private List<String> getBullets() {
		return Arrays.asList("Shared MongoDB server", 
				"100 MB Storage (not enforced)", 
				"40 concurrent connections (not enforced)");
	}
	
}