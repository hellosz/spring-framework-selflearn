package com.ralph.ioc.container.overview.annotations;

import java.lang.annotation.*;

/**
 * 自定义优先级判定注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomPrimary {
}
