package admin.com.example.administrator.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import admin.com.example.administrator.mvp.base.BaseMvpActivity;
import admin.com.example.administrator.mvp.base.IPresenter;
import admin.com.example.administrator.mvp.domain.Demo;
import admin.com.example.administrator.mvp.mvc.presenter.ISingleInterfacePresenter;
import admin.com.example.administrator.mvp.mvc.presenter.SingleInterfacePresenter;
import admin.com.example.administrator.mvp.mvc.view.ISingerInterfaceIView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity<SingleInterfacePresenter> implements ISingerInterfaceIView {

    @BindView(R.id.btn1)
    Button btn1;
    @BindView(R.id.tx1)
    TextView tx1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getData();
            }
        });
    }

    @Override
    public void showArticleSuccess(Demo bean) {
        tx1.setText(bean.toString());
    }

    @Override
    public void showArticleFail(String errorMsg) {
        tx1.setText(errorMsg);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    @Override
    protected SingleInterfacePresenter createPresenter() {
        return new SingleInterfacePresenter();
    }
}
