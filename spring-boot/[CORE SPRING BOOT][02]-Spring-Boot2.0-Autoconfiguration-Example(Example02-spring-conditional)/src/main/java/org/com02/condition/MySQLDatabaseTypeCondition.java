package org.com02.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MySQLDatabaseTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		String dbType = System.getProperty("dbType");
		return (dbType != null && dbType.equalsIgnoreCase("MYSQL"));
	}

}
