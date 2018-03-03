package navanth.com.wheatherapp.domain

import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


abstract class UseCase<T : UseCase.Request, V : UseCase.Response> {

    fun executeUseCase(t: T): Observable<V> = createObservable(t)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    abstract fun createObservable(t: T): Observable<V>

    interface Request

    interface Response
}