package constants;

public abstract class Regex
{
    public static final String FINDER_TYPE = "(.[aA-zZ](\\.))|(\\:).*";
    public static final String FINDER_TYPE_FOR_WEB_ELEMENT = "([^;]*-> )";
    public static final String FINDER_VALUE = ".*(\\:) ";
    public static final String FINDER_PROXY = "(By.)";
}
