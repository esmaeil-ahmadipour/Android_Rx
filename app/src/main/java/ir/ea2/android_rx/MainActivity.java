package ir.ea2.android_rx;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    Observable<String> observableObject;
    Observer<String> observerObject;
    String data = "www.ea2.ir";
    public static final String TAG = "TAG_LOG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // * Publish String Data .
        observableObject = Observable.just(data);


        // * Subscribe Of observableObject ;
        observerObject = new Observer<String>() {

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                Log.e(TAG , "onSubscribe : "+d.toString());

            }

            @Override
            public void onNext(@NonNull String s) {
                // * We Can Get data From Publisher.
                Log.e(TAG , "onNext : "+s);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {
                // * When Received All Data From Publisher.

            }
        };

        // * Adding Subscriber To Publisher
        observableObject.subscribe(observerObject);
    }
}
