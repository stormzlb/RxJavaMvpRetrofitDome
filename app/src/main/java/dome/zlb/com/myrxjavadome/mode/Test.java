package dome.zlb.com.myrxjavadome.mode;

/**
 * Created by zlb on 2019/1/10 19:57
 */
public class Test {


    /**
     * ErrorNum : 800
     * ErrorMsg : Ok
     * UpdateContentCn : 简体中文
     * UpdateContentEn : English
     * UpdateContentTw : 繁体
     * DpEndosVerName : v1.0.1
     * DpEndosVerCode : 2
     * DpEndosUrl : http://192.168.2.99:8080/UploadFiles/Soft/DpEndosApp/DpEndosApp_1.0.1_150 81407306.apk
     * DpEndosMd5 : c3ff08431a424d24ded076bd0c35300b
     * IsForce : true
     * UpdateDate : 2017-03-01 15:08:14
     */

    private int ErrorNum;
    private String ErrorMsg;
    private String UpdateContentCn;
    private String UpdateContentEn;
    private String UpdateContentTw;
    private String DpEndosVerName;
    private String DpEndosVerCode;
    private String DpEndosUrl;
    private String DpEndosMd5;
    private boolean IsForce;
    private String UpdateDate;

    public int getErrorNum() {
        return ErrorNum;
    }

    public void setErrorNum(int ErrorNum) {
        this.ErrorNum = ErrorNum;
    }

    public String getErrorMsg() {
        return ErrorMsg;
    }

    public void setErrorMsg(String ErrorMsg) {
        this.ErrorMsg = ErrorMsg;
    }

    public String getUpdateContentCn() {
        return UpdateContentCn;
    }

    public void setUpdateContentCn(String UpdateContentCn) {
        this.UpdateContentCn = UpdateContentCn;
    }

    public String getUpdateContentEn() {
        return UpdateContentEn;
    }

    public void setUpdateContentEn(String UpdateContentEn) {
        this.UpdateContentEn = UpdateContentEn;
    }

    public String getUpdateContentTw() {
        return UpdateContentTw;
    }

    public void setUpdateContentTw(String UpdateContentTw) {
        this.UpdateContentTw = UpdateContentTw;
    }

    public String getDpEndosVerName() {
        return DpEndosVerName;
    }

    public void setDpEndosVerName(String DpEndosVerName) {
        this.DpEndosVerName = DpEndosVerName;
    }

    public String getDpEndosVerCode() {
        return DpEndosVerCode;
    }

    public void setDpEndosVerCode(String DpEndosVerCode) {
        this.DpEndosVerCode = DpEndosVerCode;
    }

    public String getDpEndosUrl() {
        return DpEndosUrl;
    }

    public void setDpEndosUrl(String DpEndosUrl) {
        this.DpEndosUrl = DpEndosUrl;
    }

    public String getDpEndosMd5() {
        return DpEndosMd5;
    }

    public void setDpEndosMd5(String DpEndosMd5) {
        this.DpEndosMd5 = DpEndosMd5;
    }

    public boolean isIsForce() {
        return IsForce;
    }

    public void setIsForce(boolean IsForce) {
        this.IsForce = IsForce;
    }

    public String getUpdateDate() {
        return UpdateDate;
    }

    public void setUpdateDate(String UpdateDate) {
        this.UpdateDate = UpdateDate;
    }


    @Override
    public String toString() {
        return "Test{" +
                "ErrorNum=" + ErrorNum +
                ", ErrorMsg='" + ErrorMsg + '\'' +
                ", UpdateContentCn='" + UpdateContentCn + '\'' +
                ", UpdateContentEn='" + UpdateContentEn + '\'' +
                ", UpdateContentTw='" + UpdateContentTw + '\'' +
                ", DpEndosVerName='" + DpEndosVerName + '\'' +
                ", DpEndosVerCode='" + DpEndosVerCode + '\'' +
                ", DpEndosUrl='" + DpEndosUrl + '\'' +
                ", DpEndosMd5='" + DpEndosMd5 + '\'' +
                ", IsForce=" + IsForce +
                ", UpdateDate='" + UpdateDate + '\'' +
                '}';
    }
}
