package servlet;

import builder.AbstractVoucherBuilder;
import builder.VoucherBuilderFactory;
import exception.NoSuchParserTypeException;
import exception.VoucherSetBuildingException;
import exception.XMLFileNotFoundException;
import exception.XMLValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.XMLValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.InputStream;

@WebServlet(name = "uploadXMLServlet", urlPatterns = "/uploadXML")
@MultipartConfig
public class UploadXMLServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(UploadXMLServlet.class);
    private final VoucherBuilderFactory builderFactory = VoucherBuilderFactory.INSTANCE;
    private static final String SCHEMA_PATH = "/touristVouchersSchema.xsd";
    private static final String CURRENT_SERVLET = "/uploadXML";
    private static final String START_PAGE = "/index.jsp";
    private static final String RESULT_PAGE = "/WEB-INF/jsp/result.jsp";
    private static final String PARSING_ERROR_PAGE = "/WEB-INF/jsp/parsingError.jsp";
    private static final String REDIRECT_ERROR = "error";
    private static final String REDIRECT_RESULT = "result";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String redirect = (String) session.getAttribute("redirect");
        if (redirect == null) {
            redirect = "";
        }
        switch (redirect) {
            case REDIRECT_ERROR:
                request.setAttribute("errorText", session.getAttribute("errorText"));
                session.removeAttribute("errorText");
                session.removeAttribute("redirect");
                request.getRequestDispatcher(PARSING_ERROR_PAGE).forward(request, response);
                break;
            case REDIRECT_RESULT:
                request.setAttribute("parserType", session.getAttribute("parserType"));
                request.setAttribute("vouchers", session.getAttribute("vouchers"));
                session.removeAttribute("parserType");
                session.removeAttribute("vouchers");
                session.removeAttribute("redirect");
                request.getRequestDispatcher(RESULT_PAGE).forward(request, response);
                break;
            default:
                request.getRequestDispatcher(START_PAGE).forward(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        if (request.getContentType() != null) {
            Part filePart = request.getPart("file");
            try (InputStream fileInputStream = filePart.getInputStream()) {
                XMLValidator validator = new XMLValidator();
                if (validator.validate(fileInputStream, SCHEMA_PATH)) {
                    String parserType = request.getParameter("parserType");
                    AbstractVoucherBuilder builder = builderFactory.getParser(parserType);
                    try (InputStream is = filePart.getInputStream()) {
                        builder.buildSetVouchers(is);
                        HttpSession session = request.getSession();
                        session.setAttribute("redirect", REDIRECT_RESULT);
                        session.setAttribute("parserType", parserType);
                        session.setAttribute("vouchers", builder.getVouchers());
                        response.sendRedirect(CURRENT_SERVLET);
                    } catch (VoucherSetBuildingException e) {
                        redirectToErrorPage("Parsing failure", e, request, response);
                    }
                }
            } catch (XMLFileNotFoundException e) {
                redirectToErrorPage("Incorrect input file error", e, request, response);
            } catch (XMLValidationException e) {
                redirectToErrorPage("Input file validation error", e, request, response);
            } catch (NoSuchParserTypeException e) {
                redirectToErrorPage("Not found such parser type", e, request, response);
            }
        } else {
            redirectToErrorPage("Not found xml file in request", null, request, response);
        }
    }

    private void redirectToErrorPage(String errorText, Exception e,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws IOException {
        LOGGER.error(errorText, e);
        HttpSession session = request.getSession();
        session.setAttribute("redirect", REDIRECT_ERROR);
        session.setAttribute("errorText", errorText);
        response.sendRedirect(CURRENT_SERVLET);
    }


}
