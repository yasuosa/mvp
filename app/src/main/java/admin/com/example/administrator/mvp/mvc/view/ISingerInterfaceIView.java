package admin.com.example.administrator.mvp.mvc.view;

import admin.com.example.administrator.mvp.base.IView;
import admin.com.example.administrator.mvp.domain.Demo;

public interface ISingerInterfaceIView extends IView {
    void showArticleSuccess(Demo bean);

    void showArticleFail(String errorMsg);
}
