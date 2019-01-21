package org.com02.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MongoDBDatabaseTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata arg1) {
		String dbType = conditionContext.getEnvironment().getProperty("app.dbType");
		return (dbType != null && dbType.equalsIgnoreCase("MONGODB"));
	}

}
