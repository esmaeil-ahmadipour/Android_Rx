package ir.ea2.android_rx;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    Observable<List<String>> observableObject;
    Observer<List<String>> observerObject;
    String data = "www.ea2.ir";
    public static final String TAG = "TAG_LOG";
    List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // * Add To List.
        stringList.add("John");
        stringList.add("Mick");
        stringList.add("Steve");
        stringList.add("Jack");

        // * Publish String Data .
        observableObject = Observable.just(stringList);


        // * Subscribe Of observableObject ;
        observerObject = new Observer<List<String>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<String> strings) {
                int i = 0;
                while (i < stringList.size()) {
                    Log.e(TAG, "onNext : "+stringList.get(i));
                    i++;
                }
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };

        // * Adding Subscriber To Publisher
        observableObject.subscribe(observerObject);
    }
}
