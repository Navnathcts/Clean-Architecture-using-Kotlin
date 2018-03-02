package navanth.com.wheatherapp.domain.dashboard

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import navanth.com.wheatherapp.domain.UseCase
import javax.inject.Inject


class WheatherReportUseCase @Inject constructor() : UseCase<WheatherReportUseCase.Request, WheatherReportUseCase.Response>() {


    override fun createObservable(request: UseCase.Request): Observable<Response> = null!!


    class Request : UseCase.Request() {

    }

    class Response : UseCase.Response() {

    }
}