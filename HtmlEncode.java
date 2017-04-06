/**
 * Created by shure on 2017/4/6.
 */
public class HtmlEncode {
    public static void main (String[] args){
        String s = new String("<script>alert(1);</script>");
        String str = encodeHtml(s);
        System.out.println(str); // &#60;script&#62;alert(1);&#60;/script&#62;
    }

    public static String encodeHtml(String s){
        StringBuffer out = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c > 127 || c=='"' || c=='<' || c=='>') {
                out.append("&#" + (int)c + ";");
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}
