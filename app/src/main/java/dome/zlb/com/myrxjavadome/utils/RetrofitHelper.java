package dome.zlb.com.myrxjavadome.utils;

import android.util.Log;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.prefs.Preferences;

import dome.zlb.com.myrxjavadome.api.RetrofitApiService;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 辅助类
 *
 * @author zlb
 */
public class RetrofitHelper {
    private static String TGA = "RetrofitHelper";
    private long CONNECT_TIMEOUT = 60L;
    private long READ_TIMEOUT = 30L;
    private long WRITE_TIMEOUT = 30L;
    private volatile static RetrofitHelper mInstance = null;
    private Retrofit mRetrofit = null;
    private OkHttpClient okHttpClient;

    private static final String BASE_URL = "http://211.149.165.58/";

    public static RetrofitHelper getInstance() {
        synchronized (RetrofitHelper.class) {
            if (mInstance == null) {
                mInstance = new RetrofitHelper();
            }

            return mInstance;
        }
    }

    private RetrofitHelper() {
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    /**
     * 获取OkHttpClient实例
     *
     * @return
     */
    public OkHttpClient getOkHttpClient() {
        okHttpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                //.addInterceptor(new RqInterceptor())//设置okhttp拦截器，这样做的好处是可以为你的每一个retrofit2的网络请求都增加相同的head头信息，而不用每一个请求都写头信息
                .addInterceptor(new LogInterceptor())//打印日志
                .build();
        return okHttpClient;

    }

    /**
     * 请求拦截器
     */
    private class RqInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request()
                    .newBuilder()
                    .addHeader("X-APP-TYPE", "android")
                    .build();
            Response response = chain.proceed(request);
            return response;
        }
    }

    /**
     * //打印日志
     */
    private class LogInterceptor implements Interceptor {
        @Override
        public Response intercept(Interceptor.Chain chain) throws IOException {
            Request request = chain.request();
            String url = request.url().toString();
            Response response = chain.proceed(request);
            String responseString = response.body().string();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            String log = "\n\n*****请求时间*****:\n" + time + "\n*******请求路径*******:\n" + url + "\n*******报文*******:\n" + responseString + "\n \n";
            Log.d(TGA, log);
            return chain.proceed(request);
        }
    }


    public RetrofitApiService getServer() {
        return mRetrofit.create(RetrofitApiService.class);
    }

}
