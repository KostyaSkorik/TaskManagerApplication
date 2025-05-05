package by.kostya.utils;

public class JSPHelper {
    private static final String COMMON_PATH = "/WEB-INF/jsp/%s.jsp";
    public static String getPath(String path){
        return COMMON_PATH.formatted(path);
    }
}
