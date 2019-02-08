package builder;

import exception.NoSuchParserTypeException;

public enum VoucherBuilderFactory {
    INSTANCE;

    public AbstractVoucherBuilder getParser(String parserType) throws NoSuchParserTypeException {
        switch (parserType) {
            case "DOM":
                return new VoucherDOMBuilder();
            case "SAX":
                return new VoucherSAXBuilder();
            case "StAX":
                return new VoucherStAXBuilder();
            default:
                throw new NoSuchParserTypeException();
        }
    }
}
