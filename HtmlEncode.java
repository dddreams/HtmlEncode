/**
 * Created by shure on 2017/4/6.
 */
public class HtmlEncode {
    public static void main (String[] args){
        String s = new String("<script>asdif");
        String str = encodeHtml(s, false);
        System.out.println(str); // &#60;script&#62;alert(1);&#60;/script&#62;
    }
    
    /**
     * 将一些特殊字符转换为 html 实体，防止<script>标签脚本注入。
     * @param s 要转换的字符串
     * @param isChinese 是否将中文转换为 ASCII 码
     * @return
     */
    public static String encodeHtml(String s, boolean isChinese ){
        StringBuffer out = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='"' || c=='<' || c=='>') {
            	out.append("&#" + (int)c + ";");
            }else if(isChinese && c > 127){
            	out.append("&#" + (int)c + ";");
            } else {
                out.append(c);
            }
        }
        return out.toString().replaceAll(" ", "");
    }
}
