package servlet;

import builder.AbstractVoucherBuilder;
import builder.VoucherBuilderFactory;
import entity.Voucher;
import exception.NoSuchParserTypeException;
import exception.XMLFileNotFoundException;
import exception.XMLValidationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import validator.XMLValidator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/uploadXML")
@MultipartConfig
public class UploadXMLServlet extends HttpServlet {
    private static final Logger LOGGER = LogManager.getLogger(UploadXMLServlet.class);
    private final VoucherBuilderFactory builderFactory = VoucherBuilderFactory.INSTANCE;
    private static final String SCHEMA_PATH = "/touristVouchersSchema.xsd";
    private static final String RESULT_PAGE = "/WEB-INF/jsp/result.jsp";
    private static final String ERROR_PAGE = "/WEB-INF/jsp/error.jsp";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                        //TODO output vouchers
                        request.setAttribute("parserType", parserType);
                        request.setAttribute("vouchers", builder.getVouchers());
                        request.getRequestDispatcher(RESULT_PAGE).forward(request, response);
                    }
                }
            } catch (XMLFileNotFoundException e) {
                redirectToErrorPage("Incorrect input file error", e, request, response);
            } catch (XMLValidationException e) {
                redirectToErrorPage("Input file validation error", e, request, response);
            } catch (NoSuchParserTypeException e) {
                redirectToErrorPage("Not found xml file in request", null, request, response);
            }
        } else {
            redirectToErrorPage("Not found xml file in request", null, request, response);
        }


    }

    private void redirectToErrorPage(String errorText, Exception e,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws ServletException, IOException {
        LOGGER.error(errorText, e);
        request.setAttribute("errorText", errorText);
        request.getRequestDispatcher(ERROR_PAGE).forward(request, response);
    }
}
