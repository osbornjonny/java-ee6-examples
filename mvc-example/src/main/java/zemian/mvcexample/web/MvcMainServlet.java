package zemian.mvcexample.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/main/*")
public class MvcMainServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = LoggerFactory.getLogger(MvcMainServlet.class);
    private static final String SERVLET_PATH = "/main";
    private static final String TEMPLATE_PATH = "/jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        LOGGER.debug("Getting req URI={}", uri);
        
        String prefixPath = getServletContext().getContextPath() + SERVLET_PATH;
        String resPath = uri.substring(prefixPath.length());
        if (resPath.equals("") || resPath.equals("/"))
            resPath = "/index";
        resPath = TEMPLATE_PATH + resPath + ".jsp";
        LOGGER.debug("Getting resource={}", resPath);
        
        req.getRequestDispatcher(resPath).forward(req, resp);
    }
}