package admin.com.example.administrator.mvp.http;

import admin.com.example.administrator.mvp.domain.Demo;
import retrofit.http.GET;
import rx.Observable;

public interface ApiService {


    @GET("friend/json")
    Observable<Demo> getData();

}
