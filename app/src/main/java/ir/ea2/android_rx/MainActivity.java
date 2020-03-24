package ir.ea2.android_rx;

import android.os.Bundle;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViews();
        FakeApi fakeApi = new FakeApi();

        fakeApi.posts();
        Observer<List<DataModel>> observerObject = new Observer<List<DataModel>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull List<DataModel> dataModels) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

                CustomAdapter adapter = new CustomAdapter(dataModels);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
        fakeApi.listObservable.subscribe(observerObject);

    }

    private void setViews() {
        recyclerView=findViewById(R.id.ac_main_rc_main);

    }
}
