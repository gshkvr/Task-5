package validator;

import exception.XMLFileNotFoundException;
import exception.XMLValidationException;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class XMLValidator {
    public boolean validate(InputStream inputStream, String schemaName) throws XMLFileNotFoundException, XMLValidationException {
        String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(language);
        try {
            URL fileURL = getClass().getResource(schemaName);
            File schemaLocation = new File(fileURL.getFile());
            Schema schema = factory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(inputStream);
            validator.validate(source);
            return true;
        } catch (IOException e) {
            throw new XMLFileNotFoundException(e);
        } catch (SAXException e) {
            throw new XMLValidationException(e);
        }
    }
}
