package builder;

import entity.Voucher;
import entity.VoucherEnum;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.sql.Date;

public class VoucherStAXBuilder extends AbstractVoucherBuilder {
    private XMLInputFactory inputFactory;

    VoucherStAXBuilder() {
        super();
        inputFactory = XMLInputFactory.newInstance();
    }

    @Override
    public void buildSetVouchers(InputStream inputStream) {
        String name;
        try {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.VOUCHER) {
                        Voucher voucher = buildVoucher(reader);
                        vouchers.add(voucher);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            System.err.println("StAX parsing error! " + ex.getMessage());
        }
    }

    private Voucher buildVoucher(XMLStreamReader reader) throws XMLStreamException {
        Voucher voucher = new Voucher();

        voucher.setId(Integer.valueOf(reader.getAttributeValue(null, VoucherEnum.ID.getValue())));
        voucher.setType(reader.getAttributeValue(null, VoucherEnum.TYPE.getValue()));

        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VoucherEnum.valueOf(name.toUpperCase())) {
                        case COUNTRY:
                            voucher.setCountry(getXMLText(reader));
                            break;
                        case DATE:
                            String date = getXMLText(reader);
                            voucher.setDate(Date.valueOf(date));
                            break;
                        case DURATION:
                            voucher.setDuration(getXMLDuration(reader));
                            break;
                        case TRANSPORT:
                            voucher.setTransport(getXMLText(reader));
                            break;
                        case COST:
                            voucher.setCost(getXMLCost(reader));
                            break;
                        case HOTELCHARACTERISTICS:
                            voucher.setHotelCharacteristics(getXMLHotelCharacteristics(reader));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.VOUCHER) {
                        return voucher;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag voucher");
    }

    private Voucher.Duration getXMLDuration(XMLStreamReader reader) throws XMLStreamException {
        Voucher.Duration duration = new Voucher.Duration();
        duration.setUnit(reader.getAttributeValue(null, VoucherEnum.UNIT.getValue()));
        if (reader.hasNext()) {
            reader.next();
            duration.setDuration(Integer.valueOf(reader.getText()));
        }
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.END_ELEMENT:
                    String name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.DURATION) {
                        return duration;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag duration");
    }

    private Voucher.Cost getXMLCost(XMLStreamReader reader) throws XMLStreamException {
        Voucher.Cost cost = new Voucher.Cost();
        cost.setCurrency(reader.getAttributeValue(null, VoucherEnum.CURRENCY.getValue()));
        if (reader.hasNext()) {
            reader.next();
            cost.setCost(Integer.valueOf(reader.getText()));
        }
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.END_ELEMENT:
                    String name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.COST) {
                        return cost;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag cost");
    }

    private Voucher.HotelCharacteristics getXMLHotelCharacteristics(XMLStreamReader reader) throws XMLStreamException {
        Voucher.HotelCharacteristics hotelCharacteristics = new Voucher.HotelCharacteristics();
        hotelCharacteristics.setStars(Integer.valueOf(reader.getAttributeValue(null, VoucherEnum.STARS.getValue())));
        hotelCharacteristics.setTv(reader.getAttributeValue(null, VoucherEnum.TV.getValue()));
        hotelCharacteristics.setConditioner(reader.getAttributeValue(null, VoucherEnum.CONDITIONER.getValue()));
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    String name = reader.getLocalName();
                    switch (VoucherEnum.valueOf(name.toUpperCase())) {
                        case HOTELNAME:
                            hotelCharacteristics.setHotelName(getXMLText(reader));
                            break;
                        case NUTRITION:
                            hotelCharacteristics.setNutrition(getXMLText(reader));
                            break;
                        case PERSONS:
                            hotelCharacteristics.setPersons(Integer.valueOf(getXMLText(reader)));
                            break;
                    }
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (VoucherEnum.valueOf(name.toUpperCase()) == VoucherEnum.HOTELCHARACTERISTICS) {
                        return hotelCharacteristics;
                    }
                    break;
            }
        }
        throw new XMLStreamException("Unknown element in tag hotelCharacteristics");
    }


    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
