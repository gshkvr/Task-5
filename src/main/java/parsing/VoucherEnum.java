package parsing;

public enum VoucherEnum {
    TOURISTVOUCHERS("touristVouchers"),
    VOUCHER("voucher"),
    ID("id"),
    TYPE("type"),
    COUNTRY("country"),
    DATE("date"),
    DURATION("duration"),
    UNIT("unit"),
    TRANSPORT("transport"),
    COST("cost"),
    CURRENCY("currency"),
    HOTELCHARACTERISTICS("hotelCharacteristics"),
    STARS("stars"),
    TV("tv"),
    CONDITIONER("conditioner"),
    HOTELNAME("hotelName"),
    NUTRITION("nutrition"),
    PERSONS("persons");

    private String value;

    VoucherEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
