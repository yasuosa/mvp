package admin.com.example.administrator.mvp.base;

public interface  IPresenter<T extends IView>{

    /** 依附生命view
     *
     * @param view
     */
    void attachView(T view);

    /**
     * 分离View
     */
    void detachView();

    /**
     * 判断View是否已经销毁
     *
     * @return
     */
    boolean isViewAttached();
}
