package entity;

import java.util.Date;
import java.util.Objects;

public class Voucher {
    private String country;
    private Date date;
    private Duration duration;
    private String transport;
    private Cost cost;
    private HotelCharacteristics hotelCharacteristics;
    private String type;
    private int id;

    public Voucher() {
        this.duration = new Duration();
        this.cost = new Cost();
        this.hotelCharacteristics = new HotelCharacteristics();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public Cost getCost() {
        return cost;
    }

    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public HotelCharacteristics getHotelCharacteristics() {
        return hotelCharacteristics;
    }

    public void setHotelCharacteristics(HotelCharacteristics hotelCharacteristics) {
        this.hotelCharacteristics = hotelCharacteristics;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static class Duration{
        private int duration;
        private String unit;

        public Duration() {
        }

        public Duration(int duration, String unit) {
            this.duration = duration;
            this.unit = unit;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getUnit() {
            return unit;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Duration duration1 = (Duration) o;
            return duration == duration1.duration &&
                    Objects.equals(unit, duration1.unit);
        }

        @Override
        public int hashCode() {
            return Objects.hash(duration, unit);
        }
    }

    public static class Cost{
        private int cost;
        private String currency;

        public Cost() {
        }

        public Cost(int cost, String currency) {
            this.cost = cost;
            this.currency = currency;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            Cost cost1 = (Cost) o;
            return cost == cost1.cost &&
                    Objects.equals(currency, cost1.currency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cost, currency);
        }
    }

    public static class HotelCharacteristics{
        private String hotelName;
        private String nutrition;
        private int persons;
        private int stars;
        private String tv;
        private String conditioner;

        public HotelCharacteristics() {
        }

        public String getHotelName() {
            return hotelName;
        }

        public void setHotelName(String hotelName) {
            this.hotelName = hotelName;
        }

        public String getNutrition() {
            return nutrition;
        }

        public void setNutrition(String nutrition) {
            this.nutrition = nutrition;
        }

        public int getPersons() {
            return persons;
        }

        public void setPersons(int persons) {
            this.persons = persons;
        }

        public int getStars() {
            return stars;
        }

        public void setStars(int stars) {
            this.stars = stars;
        }

        public String getTv() {
            return tv;
        }

        public void setTv(String tv) {
            this.tv = tv;
        }

        public String getConditioner() {
            return conditioner;
        }

        public void setConditioner(String conditioner) {
            this.conditioner = conditioner;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {return true;}
            if (o == null || getClass() != o.getClass()) {return false;}
            HotelCharacteristics that = (HotelCharacteristics) o;
            return stars == that.stars &&
                    Objects.equals(hotelName, that.hotelName) &&
                    Objects.equals(nutrition, that.nutrition) &&
                    Objects.equals(tv, that.tv) &&
                    Objects.equals(conditioner, that.conditioner);
        }

        @Override
        public int hashCode() {
            return Objects.hash(hotelName, nutrition, stars, tv, conditioner);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (o == null || getClass() != o.getClass()) {return false;}
        Voucher voucher = (Voucher) o;
        return id == voucher.id &&
                Objects.equals(country, voucher.country) &&
                Objects.equals(date, voucher.date) &&
                Objects.equals(duration, voucher.duration) &&
                Objects.equals(transport, voucher.transport) &&
                Objects.equals(cost, voucher.cost) &&
                Objects.equals(hotelCharacteristics, voucher.hotelCharacteristics) &&
                Objects.equals(type, voucher.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, date, duration, transport, cost, hotelCharacteristics, type, id);
    }
}
