package navanth.com.wheatherapp.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


abstract class UseCase<T : UseCase.Request, V : UseCase.Response> {


    fun executeUseCase(request: T): Observable<V> = createObservable(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    abstract fun createObservable(request: Request): Observable<V>

    open class Request {

    }

    open class Response {

    }
}