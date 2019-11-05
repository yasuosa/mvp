package admin.com.example.administrator.mvp.mvc;

public interface CallBack<K,V> {

    void Success(K data);

    void Error(V errMsg);
}
