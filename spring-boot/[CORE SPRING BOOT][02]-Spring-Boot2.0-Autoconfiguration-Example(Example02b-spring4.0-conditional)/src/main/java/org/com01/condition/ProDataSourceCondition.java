package org.com01.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class ProDataSourceCondition implements Condition {

	public boolean matches(ConditionContext context	, AnnotatedTypeMetadata metaData) {
		String dbName = context.getEnvironment().getProperty("database.name");
		return dbName.equalsIgnoreCase("prod");
	}

}
