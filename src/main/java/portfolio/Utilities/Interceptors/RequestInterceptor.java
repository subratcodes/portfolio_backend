package portfolio.Utilities.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      System.out.println("LogHandlerInterceptor::preHandle()");      
      String reqHeader=request.getHeader("Connection");
      System.out.println(reqHeader);
      response.addHeader("Subrat", "Singh");
       System.out.println(request.getProtocol());
       return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("LogHandlerInterceptor::postHandle()");
        
        
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("LogHandlerInterceptor::afterCompletion()");
    }
}
