package builder;

import entity.Voucher;
import exception.DOMVoucherBuilderConstructorException;
import exception.VoucherSetBuildingException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import entity.VoucherEnum;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;

public class DOMVoucherBuilder extends AbstractVoucherBuilder {
    private DocumentBuilder docBuilder;

    DOMVoucherBuilder() throws DOMVoucherBuilderConstructorException {
        super();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new DOMVoucherBuilderConstructorException(e);
        }
    }

    @Override
    public void buildSetVouchers(InputStream fileInputStream) throws VoucherSetBuildingException {
        Document doc;
        try {
            doc = docBuilder.parse(fileInputStream);
            Element root = doc.getDocumentElement();
            NodeList vouchersList = root.getElementsByTagName(VoucherEnum.VOUCHER.getValue());
            for (int i = 0; i < vouchersList.getLength(); i++) {
                Element studentElement = (Element) vouchersList.item(i);
                Voucher voucher = buildVoucher(studentElement);
                vouchers.add(voucher);
            }
        } catch (IOException | SAXException e) {
            throw new VoucherSetBuildingException(e);
        }
    }

    private Voucher buildVoucher(Element voucherElement) {
        Voucher voucher = new Voucher();
        String id = voucherElement.getAttribute(VoucherEnum.ID.getValue());
        voucher.setId(Integer.parseInt(id));
        String type = voucherElement.getAttribute(VoucherEnum.TYPE.getValue());
        voucher.setType(type);
        voucher.setCountry(getElementTextContent(voucherElement, VoucherEnum.COUNTRY.getValue()));
        voucher.setTransport(getElementTextContent(voucherElement, VoucherEnum.TRANSPORT.getValue()));
        String date = getElementTextContent(voucherElement, VoucherEnum.DATE.getValue());
        voucher.setDate(Date.valueOf(date));
        Voucher.Duration duration = new Voucher.Duration();
        Element durationElement = (Element) voucherElement.getElementsByTagName(VoucherEnum.DURATION.getValue()).item(0);
        duration.setUnit(durationElement.getAttribute(VoucherEnum.UNIT.getValue()));
        String sDuration = getElementTextContent(voucherElement, VoucherEnum.DURATION.getValue());
        duration.setDuration(Integer.parseInt(sDuration));
        voucher.setDuration(duration);
        Voucher.Cost cost = new Voucher.Cost();
        Element costElement = (Element) voucherElement.getElementsByTagName(VoucherEnum.COST.getValue()).item(0);
        cost.setCurrency(costElement.getAttribute(VoucherEnum.CURRENCY.getValue()));
        String sCost = getElementTextContent(voucherElement, VoucherEnum.COST.getValue());
        cost.setCost(Integer.parseInt(sCost));
        voucher.setCost(cost);
        Voucher.HotelCharacteristics characteristics = new Voucher.HotelCharacteristics();
        Element characteristicsElement = (Element) voucherElement
                .getElementsByTagName(VoucherEnum.HOTELCHARACTERISTICS.getValue()).item(0);
        String stars = characteristicsElement.getAttribute(VoucherEnum.STARS.getValue());
        characteristics.setStars(Integer.parseInt(stars));
        characteristics.setConditioner(characteristicsElement.getAttribute(VoucherEnum.CONDITIONER.getValue()));
        characteristics.setTv(characteristicsElement.getAttribute(VoucherEnum.TV.getValue()));
        characteristics.setHotelName(getElementTextContent(characteristicsElement, VoucherEnum.HOTELNAME.getValue()));
        characteristics.setNutrition(getElementTextContent(characteristicsElement, VoucherEnum.NUTRITION.getValue()));
        String persons = getElementTextContent(characteristicsElement, VoucherEnum.PERSONS.getValue());
        characteristics.setPersons(Integer.parseInt(persons));
        voucher.setHotelCharacteristics(characteristics);
        return voucher;
    }

    private String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        return node.getTextContent();
    }
}
