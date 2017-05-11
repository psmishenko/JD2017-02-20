package by.it.vedom.project.java.filter;

import javax.servlet.*;
import java.io.IOException;

public class EncodingUTF8 implements Filter{
    //принимаем данные и указываем, что они в UTF-8
    private String code;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code=filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String currentEncoding=servletRequest.getCharacterEncoding();
        if (code!=null && !code.equalsIgnoreCase(currentEncoding)){
            servletRequest.setCharacterEncoding(code);
        }
        currentEncoding=servletResponse.getCharacterEncoding();
        if (code!=null && !code.equalsIgnoreCase(currentEncoding)){
            servletResponse.setCharacterEncoding(currentEncoding);
        }
        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
        code=null;
    }
}
