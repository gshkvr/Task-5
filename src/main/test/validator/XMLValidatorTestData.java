package validator;

import org.testng.annotations.DataProvider;

public class XMLValidatorTestData {
    @DataProvider(name = "testIncorrectXML")
    public Object[] testIncorrectXML() {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<touristVouchers\n" +
                "        xmlns=\"https://www.w3schools.com\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "        xsi:schemaLocation=\"https://www.w3schools.com touristVouchersSchema.xsd\">\n" +
                "    <voucher id=\"1\" type=\"rest\">\n" +
                "        <country>Italy</country>\n" +
                "        <date>2019-02-10</date>\n" +
                "        <duration unit=\"days\">6</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">600</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" tv=\"Samsung\" conditioner=\"LG\">\n" +
                "            <hotelName>Hilton</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "</touristVouchers>";
        return new Object[]{s};
    }

    @DataProvider(name = "testCorrectXML")
    public Object[] testCorrectXML() {
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<touristVouchers\n" +
                "        xmlns=\"https://www.w3schools.com\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "        xsi:schemaLocation=\"https://www.w3schools.com touristVouchersSchema.xsd\">\n" +
                "    <voucher id=\"1\" type=\"rest\">\n" +
                "        <country>Italy</country>\n" +
                "        <date>2019-02-10</date>\n" +
                "        <duration unit=\"days\">6</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">600</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" tv=\"Samsung\" conditioner=\"LG\">\n" +
                "            <hotelName>Hilton</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"2\" type=\"rest\">\n" +
                "        <country>Italy</country>\n" +
                "        <date>2019-02-20</date>\n" +
                "        <duration unit=\"days\">6</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">600</cost>\n" +
                "        <hotelCharacteristics stars=\"4\">\n" +
                "            <hotelName>Radisson</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>3</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"3\" type=\"rest\">\n" +
                "        <country>Spain</country>\n" +
                "        <date>2019-03-20</date>\n" +
                "        <duration unit=\"nights\">9</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"BYN\">2000</cost>\n" +
                "        <hotelCharacteristics stars=\"3\" tv=\"Samsung\">\n" +
                "            <hotelName>Maillot</hotelName>\n" +
                "            <nutrition>BB</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"4\" type=\"excursion\">\n" +
                "        <country>Portugal</country>\n" +
                "        <date>2019-03-20</date>\n" +
                "        <duration unit=\"days\">12</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"EURO\">800</cost>\n" +
                "        <hotelCharacteristics stars=\"2\" conditioner=\"LG\" tv=\"LG\">\n" +
                "            <hotelName>Acacia</hotelName>\n" +
                "            <nutrition>HB</nutrition>\n" +
                "            <persons>1</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"5\" type=\"rest\">\n" +
                "        <country>Turkey</country>\n" +
                "        <date>2019-04-20</date>\n" +
                "        <duration unit=\"days\">14</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">1200</cost>\n" +
                "        <hotelCharacteristics stars=\"5\" conditioner=\"Bosch\" tv=\"Samsung\">\n" +
                "            <hotelName>Vauban</hotelName>\n" +
                "            <nutrition>BB</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"6\" type=\"weekend\">\n" +
                "        <country>Poland</country>\n" +
                "        <date>2019-04-20</date>\n" +
                "        <duration unit=\"nights\">5</duration>\n" +
                "        <transport>auto</transport>\n" +
                "        <cost currency=\"EURO\">500</cost>\n" +
                "        <hotelCharacteristics stars=\"3\">\n" +
                "            <hotelName>Warsaw</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"7\" type=\"weekend\">\n" +
                "        <country>Lithuania</country>\n" +
                "        <date>2019-05-20</date>\n" +
                "        <duration unit=\"days\">3</duration>\n" +
                "        <transport>railway</transport>\n" +
                "        <cost currency=\"EURO\">300</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" conditioner=\"Bosch\">\n" +
                "            <hotelName>Devillas</hotelName>\n" +
                "            <nutrition>BB</nutrition>\n" +
                "            <persons>1</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"8\" type=\"weekend\">\n" +
                "        <country>Latvia</country>\n" +
                "        <date>2019-05-20</date>\n" +
                "        <duration unit=\"nights\">5</duration>\n" +
                "        <transport>auto</transport>\n" +
                "        <cost currency=\"EURO\">400</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" conditioner=\"LG\">\n" +
                "            <hotelName>Opera</hotelName>\n" +
                "            <nutrition>HB</nutrition>\n" +
                "            <persons>1</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"9\" type=\"rest\">\n" +
                "        <country>Sweden</country>\n" +
                "        <date>2019-06-20</date>\n" +
                "        <duration unit=\"days\">6</duration>\n" +
                "        <transport>water</transport>\n" +
                "        <cost currency=\"EURO\">600</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" tv=\"LG\">\n" +
                "            <hotelName>Radisson</hotelName>\n" +
                "            <nutrition>HB</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"10\" type=\"excursion\">\n" +
                "        <country>Russia</country>\n" +
                "        <date>2019-06-20</date>\n" +
                "        <duration unit=\"days\">5</duration>\n" +
                "        <transport>railway</transport>\n" +
                "        <cost currency=\"USD\">600</cost>\n" +
                "        <hotelCharacteristics stars=\"3\">\n" +
                "            <hotelName>Moscow</hotelName>\n" +
                "            <nutrition>BB</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"11\" type=\"pilgrimage\">\n" +
                "        <country>Israel</country>\n" +
                "        <date>2019-07-20</date>\n" +
                "        <duration unit=\"days\">4</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">1000</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" conditioner=\"Samsung\">\n" +
                "            <hotelName>Liberty</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"12\" type=\"rest\">\n" +
                "        <country>Egypt</country>\n" +
                "        <date>2019-07-20</date>\n" +
                "        <duration unit=\"nights\">10</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">800</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" tv=\"LG\">\n" +
                "            <hotelName>Pyramid</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"13\" type=\"rest\">\n" +
                "        <country>Vietnam</country>\n" +
                "        <date>2019-08-20</date>\n" +
                "        <duration unit=\"days\">14</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"USD\">1300</cost>\n" +
                "        <hotelCharacteristics stars=\"4\" conditioner=\"LG\">\n" +
                "            <hotelName>Hanoi</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>1</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"14\" type=\"excursion\">\n" +
                "        <country>Netherlands</country>\n" +
                "        <date>2019-08-20</date>\n" +
                "        <duration unit=\"days\">5</duration>\n" +
                "        <transport>auto</transport>\n" +
                "        <cost currency=\"EURO\">800</cost>\n" +
                "        <hotelCharacteristics stars=\"3\">\n" +
                "            <hotelName>Prince</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"15\" type=\"rest\">\n" +
                "        <country>France</country>\n" +
                "        <date>2019-09-20</date>\n" +
                "        <duration unit=\"days\">10</duration>\n" +
                "        <transport>air</transport>\n" +
                "        <cost currency=\"EURO\">1400</cost>\n" +
                "        <hotelCharacteristics stars=\"3\">\n" +
                "            <hotelName>Republic</hotelName>\n" +
                "            <nutrition>HB</nutrition>\n" +
                "            <persons>2</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "    <voucher id=\"16\" type=\"rest\">\n" +
                "        <country>Ukraine</country>\n" +
                "        <date>2019-09-20</date>\n" +
                "        <duration unit=\"days\">10</duration>\n" +
                "        <transport>railway</transport>\n" +
                "        <cost currency=\"USD\">500</cost>\n" +
                "        <hotelCharacteristics stars=\"5\" conditioner=\"Bosch\" tv=\"LG\">\n" +
                "            <hotelName>Odessa</hotelName>\n" +
                "            <nutrition>AI</nutrition>\n" +
                "            <persons>1</persons>\n" +
                "        </hotelCharacteristics>\n" +
                "    </voucher>\n" +
                "\n" +
                "</touristVouchers>";
        return new Object[]{s};
    }
}
