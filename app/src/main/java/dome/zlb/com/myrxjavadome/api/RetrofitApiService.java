package dome.zlb.com.myrxjavadome.api;

import java.util.LinkedHashMap;
import java.util.Map;

import dome.zlb.com.myrxjavadome.mode.Info;
import dome.zlb.com.myrxjavadome.mode.Test;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by zlb on 2019/1/10 14:46
 */
public interface RetrofitApiService {

    /**
     * getInfoCall
     *
     * @return
     */
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hello%20world")
    Observable<Info> getInfoCall();


    /**
     * 获取内窥镜APK最新版本
     */
    @GET("ObdstarAPI/GetLastDpEndosApk.ashx")
    Observable<Test> getTestCall(@QueryMap LinkedHashMap<String, String> params);


}
