package builder;

import entity.Voucher;
import entity.VoucherEnum;
import exception.SAXVoucherBuilderConstructorException;
import exception.VoucherSetBuildingException;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.util.EnumSet;

public class SAXVoucherBuilder extends AbstractVoucherBuilder {
    private Voucher current;
    private VoucherEnum currentEnum;
    private EnumSet<VoucherEnum> withText;
    private XMLReader reader;

    SAXVoucherBuilder() throws SAXVoucherBuilderConstructorException {
        VoucherHandler voucherHandler = new VoucherHandler();
        try {
            SAXParserFactory parserFactory = SAXParserFactory.newInstance();
            SAXParser parser = parserFactory.newSAXParser();
            reader = parser.getXMLReader();
            reader.setContentHandler(voucherHandler);
        } catch (SAXException | ParserConfigurationException e) {
            throw new SAXVoucherBuilderConstructorException(e);
        }
    }

    @Override
    public void buildSetVouchers(InputStream fileInputStream) throws VoucherSetBuildingException {
        try {
            InputSource source = new InputSource(fileInputStream);
            reader.parse(source);
        } catch (SAXException | IOException e) {
            throw new VoucherSetBuildingException(e);
        }
    }

    private class VoucherHandler extends DefaultHandler {
        VoucherHandler() {
            withText = EnumSet.range(VoucherEnum.ID, VoucherEnum.PERSONS);
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) {
            if (VoucherEnum.VOUCHER.getValue().equals(qName)) {
                current = new Voucher();
                String id = attributes.getValue(0);
                current.setId(Integer.valueOf(id));
                String type = attributes.getValue(1);
                current.setType(type);
            } else if (VoucherEnum.DURATION.getValue().equals(qName)) {
                String unit = attributes.getValue(0);
                current.getDuration().setUnit(unit);
                VoucherEnum temp = VoucherEnum.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }

            } else if (VoucherEnum.COST.getValue().equals(qName)) {
                String currency = attributes.getValue(0);
                current.getCost().setCurrency(currency);
                VoucherEnum temp = VoucherEnum.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            } else if (VoucherEnum.HOTELCHARACTERISTICS.getValue().equals(qName)) {
                String stars = attributes.getValue(0);
                current.getHotelCharacteristics().setStars(Integer.parseInt(stars));
                String tv = attributes.getValue(VoucherEnum.TV.getValue());
                current.getHotelCharacteristics().setTv(tv);
                String conditioner = attributes.getValue(VoucherEnum.CONDITIONER.getValue());
                current.getHotelCharacteristics().setConditioner(conditioner);
                VoucherEnum temp = VoucherEnum.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            } else {
                VoucherEnum temp = VoucherEnum.valueOf(qName.toUpperCase());
                if (withText.contains(temp)) {
                    currentEnum = temp;
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) {
            if (VoucherEnum.VOUCHER.getValue().equals(qName)) {
                vouchers.add(current);
            }
        }

        @Override
        public void characters(char[] ch, int start, int length) {
            String s = new String(ch, start, length).trim();
            if (currentEnum != null) {
                switch (currentEnum) {
                    case COUNTRY:
                        current.setCountry(s);
                        break;
                    case DATE:
                        current.setDate(Date.valueOf(s));
                        break;
                    case TRANSPORT:
                        current.setTransport(s);
                        break;
                    case DURATION:
                        current.getDuration().setDuration(Integer.parseInt(s));
                        break;
                    case COST:
                        current.getCost().setCost(Integer.parseInt(s));
                        break;
                    case HOTELCHARACTERISTICS:
                        break;
                    case HOTELNAME:
                        current.getHotelCharacteristics().setHotelName(s);
                        break;
                    case NUTRITION:
                        current.getHotelCharacteristics().setNutrition(s);
                        break;
                    case PERSONS:
                        current.getHotelCharacteristics().setPersons(Integer.parseInt(s));
                        break;
                    default:
                        throw new EnumConstantNotPresentException(
                                currentEnum.getDeclaringClass(), currentEnum.name());
                }
            }
            currentEnum = null;
        }
    }
}
