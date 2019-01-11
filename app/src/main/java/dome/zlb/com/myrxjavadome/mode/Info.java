package dome.zlb.com.myrxjavadome.mode;

import android.util.Log;

/**
 * Created by zlb on 2019/1/10 14:49
 */
public class Info {

    /**
     * status : 1
     * content : {"from":"en-EU","to":"zh-CN","out":"示例","vendor":"ciba","err_no":0}
     */

    private int status;
    private ContentBean content;

    public static class ContentBean {
        /**
         * from : en-EU
         * to : zh-CN
         * out : 示例
         * vendor : ciba
         * err_no : 0
         */
        private String from;
        private String to;
        private String out;
        private String vendor;
        private int err_no;

    }

    //定义 输出返回数据 的方法
    public void show() {
        Log.d("RxJava", content.out);
    }
}
