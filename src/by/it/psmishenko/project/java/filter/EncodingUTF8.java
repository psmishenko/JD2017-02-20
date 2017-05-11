package by.it.psmishenko.project.java.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by GN on 10.05.2017.
 */
public class EncodingUTF8 implements Filter {
    private String code;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        code = filterConfig.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String currentEncoding = servletRequest.getCharacterEncoding();
        if(code!=null && !code.equalsIgnoreCase(currentEncoding)){
            servletRequest.setCharacterEncoding(code);
        }
        currentEncoding = servletResponse.getCharacterEncoding();
        if(code!=null && !code.equalsIgnoreCase(currentEncoding)){
            servletRequest.setCharacterEncoding(code);
        }
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
