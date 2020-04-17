package constants;

public abstract class Constants
{

    private Constants()
    {
    }

    public abstract static class Arguments
    {

        public static final String FIRST = "arguments[0]";
        public static final String SECOND = "arguments[1]";
        public static final String CLICK_FIRST = "arguments[0].click();";
        public static final String LENGTH = "arguments[0].length;";

    }

    public abstract static class LocalStorage
    {
        public static final String REMOVE_ITEM = "window.localStorage.removeItem(\"%s\");";
        public static final String GET_ITEM = "return window.localStorage.getItem(\"%s\");";
        public static final String GET_KEY = "return window.localStorage.key(\"%s\");";
        public static final String LENGTH = "return window.localStorage.length;";
        public static final String SET_ITEM = "window.localStorage.setItem(\"%s\",%s);";
        public static final String CLEAR = "window.localStorage.clear();";
    }

    public abstract static class GoToUrl
    {

        public static final String HREF = "window.location.href =" + Arguments.FIRST;

    }

    public abstract static class SessionStorage
    {
        public static final String REMOVE_ITEM = "window.sessionStorage.removeItem(\"%s\");";
        public static final String GET_ITEM = "return window.sessionStorage.getItem(\"%s\");";
        public static final String GET_KEY = "return window.sessionStorage.key(\"%s\");";
        public static final String LENGTH = "return window.sessionStorage.length;";
        public static final String SET_ITEM = "window.sessionStorage.setItem(\"%s\",%s);";
        public static final String CLEAR = "window.sessionStorage.clear();";

    }

    public abstract static class Scroll
    {

        public static final String VIEW = Arguments.FIRST + ".scrollIntoView(true);";
        public static final String DOWN = "window.scrollTo(0, document.body.scrollHeight);";
        public static final String UP = "window.scrollTo(0, -document.body.scrollHeight);";
        public static final String PAGE_CENTER = "window.scrollTo(0, document.body.offsetHeight/2);";
        public static final String HORIZONTALLY = "window.scrollTo(" + Arguments.FIRST + ", 0);";
        public static final String VERTICALLY = "window.scrollTo(0," + Arguments.FIRST + ");";
        public static final String HORIZONTALLY_AND_VERTICALLY = "window.scrollTo(" + Arguments.FIRST + "," + Arguments.SECOND + ");";
        public static final String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window" +
                ".innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
    }

    public abstract static class SetValue
    {
        public static final String SEND_KEYS = Arguments.FIRST + ".value = " + Arguments.SECOND;
    }

    public abstract static class Clear
    {
        public static final String CLEAR = Arguments.FIRST + ".value = ''";
    }

    public abstract static class Function
    {

        public static final String SHOW = ".show()";

    }

    public abstract static class DelayedGreeting
    {

        public static final String SLEEP = "function sleep(milliseconds) { var start = new Date().getTime(); for (var i = 0; i < 1e7; " +
                "i++) {" +
                " if ((new Date().getTime() - start) > milliseconds){ break; } } }; sleep(" + Arguments.FIRST + ");";

    }

    public abstract static class NewTab
    {
        public static final String NEW_TAB = "var win = window.open(" + Arguments.FIRST + ", '_blank'); win.focus();";
    }

    public abstract static class PageRefresh
    {
        public static final String REFRESH = "location.reload()";
    }

    public abstract static class GetLocationPathName
    {
        public static final String LOCATION_PATH_NAME = "return location.pathname";
    }

    public abstract static class GetCurrentUrl
    {
        public static final String CURRENT_URL = "return location.href";

    }

    public abstract static class Decode
    {
        public static final String DECODE = "return decodeURI(" + Arguments.FIRST + ")";

    }

}
