package util;

public enum Pieces
{
    FUNCTION_NAME("function_name"),
    SCRIPT_PATH("script_path");

    private final String piece;

    Pieces(final String piece)
    {
        this.piece = piece;
    }

    public String getValue()
    {
        return piece;
    }

}
