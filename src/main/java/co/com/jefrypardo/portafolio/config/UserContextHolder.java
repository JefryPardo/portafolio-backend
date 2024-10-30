package co.com.jefrypardo.portafolio.config;

public class UserContextHolder {

    private static final ThreadLocal<String> IPCONTEXT = new InheritableThreadLocal<>();
    private static final ThreadLocal<String> ORIGINCONTEXT = new InheritableThreadLocal<>();

    private UserContextHolder(){
        
    }
    
    public static void setIpPeticion(String ip) {
        IPCONTEXT.set(ip);
    }

    public static String getIpPeticion() {
        return IPCONTEXT.get();
    }

    public static void setOriginPeticion(String origin) {
        ORIGINCONTEXT.set(origin);
    }

    public static String getOriginPeticion() {
        return ORIGINCONTEXT.get();
    }
    
    public static void clear() {
        IPCONTEXT.remove();
        ORIGINCONTEXT.remove();
    }
}
    