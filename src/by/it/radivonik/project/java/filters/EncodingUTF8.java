package by.it.radivonik.project.java.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Radivonik on 10.05.2017.
 */
public class EncodingUTF8 implements Filter {
    private String code;

    @Override
    public void init(FilterConfig config) throws ServletException {
        code = config.getInitParameter("encoding");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        String codeResp = resp.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeResp)) {
            resp.setCharacterEncoding(code);
        }

        String codeReq = req.getCharacterEncoding();
        if (code != null && !code.equalsIgnoreCase(codeReq)) {
            req.setCharacterEncoding(code);
        }

        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {
        code = null;
    }
}
