package builder;

import entity.Voucher;
import exception.DOMVoucherBuilderConstructorException;
import exception.VoucherSetBuildingException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

public class DOMVoucherBuilderTest {

    @Test(dataProvider = "testData", dataProviderClass = VoucherBuilderTestData.class)
    public void testBuildSetVouchers(String xml, Set<Voucher> vouchers) throws DOMVoucherBuilderConstructorException {
        //given
        DOMVoucherBuilder builder = new DOMVoucherBuilder();
        //when
        try (InputStream stream = new ByteArrayInputStream(xml.getBytes())) {
            builder.buildSetVouchers(stream);
        } catch (VoucherSetBuildingException | IOException e) {
            e.printStackTrace();
        }
        //then
        Assert.assertEquals(vouchers, builder.getVouchers());
    }

    @Test(dataProvider = "testException", dataProviderClass = VoucherBuilderTestData.class,
            expectedExceptions = VoucherSetBuildingException.class)
    public void testException(String xml) throws DOMVoucherBuilderConstructorException, VoucherSetBuildingException {
        //given
        DOMVoucherBuilder builder = new DOMVoucherBuilder();
        //when
        try (InputStream stream = new ByteArrayInputStream(xml.getBytes())) {
            builder.buildSetVouchers(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}