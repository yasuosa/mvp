package admin.com.example.administrator.mvp.mvc.presenter;

import admin.com.example.administrator.mvp.base.BasePresenter;
import admin.com.example.administrator.mvp.domain.Demo;
import admin.com.example.administrator.mvp.mvc.CallBack;
import admin.com.example.administrator.mvp.mvc.model.SingleInterfaceModel;
import admin.com.example.administrator.mvp.mvc.view.ISingerInterfaceIView;



public class SingleInterfacePresenter extends BasePresenter<ISingerInterfaceIView> implements ISingleInterfacePresenter {
    private SingleInterfaceModel model;



    public SingleInterfacePresenter() {
        model=new SingleInterfaceModel();
    }

    public void getData(){
        model.getData(new CallBack<Demo,String>() {
            @Override
            public void Success(Demo data) {
                System.out.println(data.toString());
                if(isViewAttached()){
                    mView.showArticleSuccess(data);
                }
            }

            @Override
            public void Error(String errMsg) {
                if(isViewAttached()){
                    mView.showArticleFail(errMsg);
                }
            }

        });
    }
}
