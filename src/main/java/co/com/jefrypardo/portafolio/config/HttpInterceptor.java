package co.com.jefrypardo.portafolio.config;

import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

@Log4j2
@Component
public class HttpInterceptor implements HandlerInterceptor {

    private static final int MAX_REQUESTS_PER_MINUTE = 5;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("Interceptando petición a: " + request.getRequestURI());

        // Aquí va la lógica para obtener IP, consultar Redis y limitar
        String ip = getClientIP(request);
        String redisKey = "rate_limit:" + ip;
        Long requests = redisTemplate.opsForValue().increment(redisKey);

        log.info("RedisKey: {}, requests: {}", redisKey, requests);
        
        if (requests == 1) {
            redisTemplate.expire(redisKey, 1800, TimeUnit.SECONDS);
        }

        if (requests != null && requests > MAX_REQUESTS_PER_MINUTE) {
            response.setStatus(429);
            response.getWriter().write("Demasiadas solicitudes. Por favor espera un momento.");
            return false;
        }

        return true;
    }
    
    private String getClientIP(HttpServletRequest request) {
        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        } else {
            ipAddress = ipAddress.split(",")[0].trim();
        }
        return ipAddress;
    }

}
