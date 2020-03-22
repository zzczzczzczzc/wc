import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class wc{
    public static void main(String[] args) {
        String str = new String();
        for (int i = 0; i < args.length; i++)
            str += args[i];                             //命令行读取参数
        char[] ch = str.toCharArray();
        int wordsNumbers = 0;
        int charNumbers = 0;
        int lineNumbers = 0;
        String text = "";                              //文件名
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '-')
                i++;
            else
                text += ch[i];
        }
        File file = new File(new getPath().getPath(text));
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {                       //按行读取
                charNumbers += s.length();                              //字符数
                if(charNumbers > 0) {
                    wordsNumbers += s.split("\\s+").length;      //空格分离字符串，统计词数
                    lineNumbers++;                                      //行数
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 0; j < ch.length; j++) {
            if (ch[j] == '-' && ch[j+1] == 'c')
                System.out.println("字符数：" + charNumbers);
            else if (ch[j] == '-' && ch[j+1] == 'w')
                System.out.println("词数：" + wordsNumbers);
            else if (ch[j] == '-' && ch[j+1] == 'l')
                System.out.println("行数：" + lineNumbers);
        }
    }
}
class getPath{                                                      //取得文件的相对路径
    public String getPath(String str){
        String p = this.getClass().getClassLoader().getResource(str).getPath();
        return p;
    }
}



