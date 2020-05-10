package com.capg.fms.gateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capg.fms.gateway.model.UserCredentials;
import com.capg.fms.gateway.model.UserInfo;
import com.capg.fms.gateway.service.MyUserDetailsService;
import com.capg.fms.gateway.util.TokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class AuthenticationFilter extends ZuulFilter{

	@Autowired
	private MyUserDetailsService userDetailsService;
	@Autowired
	private TokenUtil tokenUtil;

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
	      RequestContext context = RequestContext.getCurrentContext();
	        HttpServletRequest request = context.getRequest();
	        String token = request.getHeader("Authorization");
	        System.out.println("token fetched from headers="+token);
	        String uri=request.getRequestURI();
	        
	       

	        if (token != null && !token.isEmpty()) {
	        	
	        	UserCredentials cred=tokenUtil.decode(token);
	        	UserInfo user=userDetailsService.loadUserByUserCrenditials(cred);
	        	 if(uri.contains("users/a/")) {
	        		 if(user.getUserType().equalsIgnoreCase("admin")) {
	        			 return null;
	        		 }
	        	 }
	        	 else if(uri.contains("users/u/")) {
	        		 if(user.getUserType().equalsIgnoreCase("user")) {
	        			 return null;
	        		 }
	        	 }
	        	 
	        }
	        else if(uri.contains("users/p/")) {
        		return null;
        	 }
	        	
	        	context.setSendZuulResponse(false);
	        	context.setResponseStatusCode(401);
	        	context.setResponseBody("Unauthorized");
	        	return null;
	        	
	        }

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
