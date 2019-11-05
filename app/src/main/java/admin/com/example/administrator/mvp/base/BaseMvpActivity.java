package admin.com.example.administrator.mvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public abstract class BaseMvpActivity<T extends IPresenter> extends AppCompatActivity implements IView  {

    private static final String TAG = "BaseMvpActivity";
    protected T mPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
        }
    }

    protected abstract T createPresenter();
    protected  void  initPresenter(){
        mPresenter=createPresenter();
        if(mPresenter!=null){
            mPresenter.attachView(this);
        }
    }

}
