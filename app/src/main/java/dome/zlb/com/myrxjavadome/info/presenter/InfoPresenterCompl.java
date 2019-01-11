package dome.zlb.com.myrxjavadome.info.presenter;


import java.util.LinkedHashMap;

import dome.zlb.com.myrxjavadome.info.view.IInfoView;
import dome.zlb.com.myrxjavadome.mode.Test;
import dome.zlb.com.myrxjavadome.utils.RetrofitHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by zlb on 2019/1/10 17:33
 */
public class InfoPresenterCompl implements IInfoPresenter {

    private IInfoView mInfoView;

    public InfoPresenterCompl(IInfoView infoView) {

        this.mInfoView = infoView;
    }

    @Override
    public void loadData() {

        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        params.put("apkVerCode", "v1.0");
        params.put("dpType", "DP80");
        params.put("dpSysVerCode", "20170308");
        params.put("proSn", "951499990029");
        params.put("reqfrom", "Android");
        params.put("sign", "5B6530F31C12120054BE920BDF5CABD3");

        RetrofitHelper.getInstance().getServer()
                .getTestCall(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Test>() {
                    @Override
                    public void accept(Test test) throws Exception {
                        //这里已经是主线程了
                        mInfoView.show(test.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //处理错误
                    }
                });


    }

}
