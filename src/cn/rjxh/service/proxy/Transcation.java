package cn.rjxh.service.proxy;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Transcation {
	boolean readOnly() default true;
}
