package com.ruibing.home.common;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/** @author Baijl
 * 2020/9/27 
 * 16:20 
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ReturnResult {
}
