package Filters;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginFilter implements Filter {
    private FilterConfig filterConfig = null;
    
    @Override
    public void init(FilterConfig filterConfig){
        this.filterConfig = filterConfig;
    }
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        ServletContext mySC = filterConfig.getServletContext();
        
        String filterName = filterConfig.getFilterName();
        String servletPath = "Servlet path: " + httpRequest.getServletPath();
        
        mySC.log(filterName + " | " + servletPath + " | BEFORE request MP");
        
        chain.doFilter(httpRequest, httpResponse);
        
        mySC.log(filterName + " | " + servletPath + " | AFTER request MP"); 
    }
    
    @Override
    public void destroy(){
        filterConfig = null;
    }
    
}
 