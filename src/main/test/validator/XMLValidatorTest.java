package validator;

import exception.XMLFileNotFoundException;
import exception.XMLValidationException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XMLValidatorTest {
    private final String SCHEMA_PATH = "/touristVouchersSchema.xsd";
    private XMLValidator validator = new XMLValidator();


    @Test(dataProvider = "testCorrectXML", dataProviderClass = XMLValidatorTestData.class)
    public void testValidateCorrectXML(String xml) {
        //when
        boolean validationResult = false;
        try (InputStream stream = new ByteArrayInputStream(xml.getBytes())) {
            if (validator.validate(stream, SCHEMA_PATH)) {
                validationResult = true;
            }
        } catch (XMLFileNotFoundException | XMLValidationException | IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertTrue(validationResult);
    }

    @Test(dataProvider = "testIncorrectXML", dataProviderClass = XMLValidatorTestData.class,
            expectedExceptions = XMLValidationException.class)
    public void testValidateIncorrectXML(String xml) throws XMLFileNotFoundException, XMLValidationException, IOException {
        //when
        boolean validationResult = false;
        try (InputStream stream = new ByteArrayInputStream(xml.getBytes())) {
            if (validator.validate(stream, SCHEMA_PATH)) {
                validationResult = true;
            }
        }
        //then
        Assert.assertTrue(validationResult);
    }
}