package dome.zlb.com.myrxjavadome.info;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import dome.zlb.com.myrxjavadome.R;
import dome.zlb.com.myrxjavadome.info.presenter.IInfoPresenter;
import dome.zlb.com.myrxjavadome.info.presenter.InfoPresenterCompl;
import dome.zlb.com.myrxjavadome.info.view.IInfoView;

public class InfoActivity extends AppCompatActivity implements IInfoView {

    private IInfoPresenter infoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
    }

    @Override
    public void initData() {

        infoPresenter = new InfoPresenterCompl(this);
        infoPresenter.loadData();

    }

    @Override
    public void show(String result) {
        TextView tv = findViewById(R.id.tv_content);
        tv.setText(result);
    }

}
