package com.cherrypicks.tcc.cms.api.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PermissionCheckInterceptor extends HandlerInterceptorAdapter {

    private final Log logger = LogFactory.getLog(this.getClass());
    
    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws Exception {
        logger.debug("PermissionCheckInterceptor.preHandle run....");
        
        return true;
    }
    
}
