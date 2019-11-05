package admin.com.example.administrator.mvp.base;

public class BasePresenter<T extends IView> implements IPresenter<T> {

    protected T mView;

    @Override
    public void attachView(T view) {
        this.mView=view;
    }

    @Override
    public void detachView() {
        if(mView!=null) {
            mView=null;
        }
    }

    @Override
    public boolean isViewAttached() {
        return mView !=null;
    }
}
