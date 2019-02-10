package builder;

import exception.DOMVoucherBuilderConstructorException;
import exception.NoSuchParserTypeException;
import exception.SAXVoucherBuilderConstructorException;

public enum VoucherBuilderFactory {
    INSTANCE;

    public AbstractVoucherBuilder getParser(String parserType) throws NoSuchParserTypeException, DOMVoucherBuilderConstructorException, SAXVoucherBuilderConstructorException {
        switch (parserType) {
            case "DOM":
                return new DOMVoucherBuilder();
            case "SAX":
                return new SAXVoucherBuilder();
            case "StAX":
                return new StAXVoucherBuilder();
            default:
                throw new NoSuchParserTypeException();
        }
    }
}
