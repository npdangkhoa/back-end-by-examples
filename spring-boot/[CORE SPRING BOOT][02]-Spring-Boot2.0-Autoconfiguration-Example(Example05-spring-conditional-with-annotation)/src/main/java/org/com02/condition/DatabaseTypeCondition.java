package org.com02.condition;

import java.util.Map;

import org.com03.annotation.DatabaseType;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DatabaseTypeCondition implements Condition {

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata metadata) {
		Map<String, Object> attribute = metadata.getAnnotationAttributes(DatabaseType.class.getName());
		String type = (String)attribute.get("value");
		String enabledDBType = System.getProperty("dbType", "MYSQL");
		 return (enabledDBType != null && type != null && enabledDBType.equalsIgnoreCase(type));
	}

}
