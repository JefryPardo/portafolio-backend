package co.com.jefrypardo.portafolio.config;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class HttpInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Enumeration<String> headerNames = request.getHeaderNames();
        log.info("Path Solicitido: [{}]", request.getRequestURI());
        while (headerNames.hasMoreElements()) {
            String key = headerNames.nextElement();
            String value = request.getHeader(key);
            log.info("  key: [{}] - value: [{}]", key, value);
            if (key.equals("Origin")) {
                UserContextHolder.setOriginPeticion(value);
                log.info("  Headers : Origin: [{}]", value);
            }
            if (key.equals("Host")) {
                
                UserContextHolder.setIpPeticion(value.split(",")[0].trim());
                log.info("  Headers : Host: [{}]", value);
                
            }
        }

        return true;
    }

}
