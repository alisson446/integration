package br.com.integration.controller.interceptor;

import javax.ejb.BeforeCompletion;
import javax.inject.Inject;
import javax.interceptor.Interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import br.com.caelum.vraptor.InterceptionException;

@Interceptor
public class CORSInterceptor {
     
    private HttpServletRequest request;
    private HttpServletResponse response;
 
    /**
     * @deprecated
     */
    public CORSInterceptor() {}
 
    @Inject
    public CORSInterceptor(    HttpServletRequest request,
                            HttpServletResponse response ) {
        this.request = request;
        this.response = response;
    }
 
    @BeforeCompletion
    public void intercept() throws InterceptionException {
         
        String origin = request.getHeader("origin") != null ? request.getHeader("origin") : "*";
         
        response.addHeader("Access-Control-Allow-Origin", origin);
        response.addHeader("Access-Control-Allow-Credentials", "true");
        response.addHeader("Access-Control-Expose-Headers", "Content-Type, Location");
    }
 
}