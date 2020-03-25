package ir.ea2.android_rx;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;

class FakeApi {
    private List<DataModel> list = new ArrayList<>();
    public Observable<List<DataModel>> listObservable;

    public void posts() {
        for (int i = 0; i <= 3; i++) {
            String personId = String.valueOf(i);
            list.add(new DataModel(personId, "Person" + personId));
        }
        listObservable = Observable.just(list);
    }
}


// * Singleton Pattern :
/*
        class FakeApi {
            private static final FakeApi ourInstance = new FakeApi();

            static FakeApi getInstance() {
                return ourInstance;
            }

            private FakeApi() {
            }


            private List<DataModel> list = new ArrayList<>();

            Observable<List<DataModel>> getListObservable() {
                for (int i = 0; i <= 3; i++) {
                    String personId = String.valueOf(i);
                    list.add(new DataModel(personId, "Person" + personId));
                }
                return Observable.just(list);
            }
        }
 */