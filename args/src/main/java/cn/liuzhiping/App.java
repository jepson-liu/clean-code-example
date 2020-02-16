package cn.liuzhiping;

import cn.liuzhiping.args.Args;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //正例：-l true -p 9999 -d D:\workspace\examples\clean-code-example\log
        //反例：-l t -p string -d D:\workspace\examples\clean-code-example\log
        try {
            Args arg = new Args("l,p#,d*", args);
            boolean logging = arg.getBoolean('l');
            int port = arg.getInt('p');
            String directory = arg.getString('d');
            executeApplication(logging, port, directory);
        } catch (Exception e) {
            System.out.printf("Argument error: %s\n", e.getMessage());
        }
    }

    private static void executeApplication(boolean logging, int port, String directory) {
        System.out.printf("logging: %s;\tport: %d;\tdirectory: %s", logging, port, directory);
    }
}
