package builder;

import entity.Voucher;
import org.testng.annotations.DataProvider;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class VoucherBuilderTestData {
    @DataProvider(name = "testData")
    public Object[][] testData() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
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

        Voucher voucher = new Voucher();
        voucher.setId(1);
        voucher.setType("rest");
        voucher.setCountry("Italy");
        voucher.setDate(Date.valueOf("2019-02-10"));
        voucher.setTransport("air");
        voucher.getDuration().setUnit("days");
        voucher.getDuration().setDuration(6);
        voucher.getCost().setCurrency("USD");
        voucher.getCost().setCost(600);
        voucher.getHotelCharacteristics().setStars(4);
        voucher.getHotelCharacteristics().setTv("Samsung");
        voucher.getHotelCharacteristics().setConditioner("LG");
        voucher.getHotelCharacteristics().setHotelName("Hilton");
        voucher.getHotelCharacteristics().setNutrition("AI");
        voucher.getHotelCharacteristics().setPersons(2);

        Set<Voucher> vouchers = new HashSet<>();
        vouchers.add(voucher);

        return new Object[][]{{xml, vouchers}};
    }

    @DataProvider(name = "testException")
    public Object[] testException() {
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<touristVouchers\n" +
                "        xmlns=\"https://www.w3schools.com\"\n" +
                "        xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n" +
                "        xsi:schemaLocation=\"https://www.w3schools.com touristVouchersSchema.xsd\">\n" +
                "    <voucher id=\"1\" type=\"rest\">\n" +
                "        <country>Italy</country>\n" +
                "        <date>2019-02-10</date>\n" +
                "        <duration unit=\"days\">6</duration>\n" +
                "        <transport>air\n" +
                "    </voucher>\n" +
                "</touristVouchers>";

        return new Object[]{xml};
    }
}
