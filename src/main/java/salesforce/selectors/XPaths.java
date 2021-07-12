package salesforce.selectors;

public enum XPaths {

    ASSET_NAME("(//div[contains(@class, \'uiInputText\')][.//label])[1]/input"),
    SERIAL_NUMBER("(//div[contains(@class, \'uiInputText\')][.//label])[2]/input"),
    QUANTITY("(//input[contains(@class, \'uiInputSmartNumber\')])[1]"),
    PRICE("(//input[contains(@class, \'uiInputSmartNumber\')])[2]"),
    DESCRIPTION("//textarea"),
    INSTALL_DATE("(//div[contains(@class,\'uiInputDate\')]/div/input)[1]"),
    PURCHASE_DATE("(//div[contains(@class,\'uiInputDate\')]/div/input)[2]"),
    USAGE_DATE("(//div[contains(@class,\'uiInputDate\')]/div/input)[3]"),
    ACTIVE("//div[@class=\'slds-form-element__control\']//input[@type=\'checkbox\']"),
    STATUS("//a[@class=\'select\']"),
    STATUS_OPTIONS("//a[@title=\'Shipped\']"),
    PRODUCT("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[2]"),
    PRODUCT_OPTIONS("(//div[@class=\'listContent\']//a)[3]"),
    ACCOUNT("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[1]"),
    ACCOUNT_OPTIONS("(//div[@role=\'listbox\']//a)[1]"),
    CONTACT("(//div[@class=\'autocompleteWrapper slds-grow\']/input)[3]"),
    CONTACT_OPTIONS("(//div[@class=\'listContent\']//a)[7]"),
    BUTTON_DELETE("//button[@title=\'Guardar\']"),
    ASSET_TITLE("//h1/div/span");

    private String selector;

    XPaths(String selector) {
        this.selector = selector;
    }

    public String get() {
        return selector;
    }
}
