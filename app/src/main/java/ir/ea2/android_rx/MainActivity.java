package ir.ea2.android_rx;

import android.os.Bundle;
import android.util.Log;
import java.util.concurrent.TimeUnit;
import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "TAG_LOG";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Observable<Long> observable = Observable.timer(10,TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Log.e(TAG, "Start Now .." );

     observable.subscribe(new Observer<Long>() {
         @Override
         public void onSubscribe(@NonNull Disposable d) {

         }

         @Override
         public void onNext(@NonNull Long aLong) {
            Log.e(TAG, "Finish After 10 Seconds .." );
         }

         @Override
         public void onError(@NonNull Throwable e) {

         }

         @Override
         public void onComplete() {

         }
     });
    }
}
