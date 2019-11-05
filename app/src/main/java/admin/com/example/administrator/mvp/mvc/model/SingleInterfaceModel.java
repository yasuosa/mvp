package admin.com.example.administrator.mvp.mvc.model;

import android.util.Log;

import admin.com.example.administrator.mvp.domain.Demo;
import admin.com.example.administrator.mvp.http.RetrofigFactory;
import admin.com.example.administrator.mvp.mvc.CallBack;
import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class SingleInterfaceModel  implements  ISingleIntefaceModel{

    private static final String TAG = "SingleInterfaceModel";
    public void getData(final CallBack callBack){
        RetrofigFactory.getInstance()
                .api()
                .getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Demo>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable throwable) {
                        callBack.Error(throwable.getMessage());
                    }

                    @Override
                    public void onNext(Demo demo) {
                        callBack.Success(demo);
                    }
                });
    }

}
