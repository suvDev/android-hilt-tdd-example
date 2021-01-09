package com.myoldschool.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.myoldschool.network.ApiRepository
import com.myoldschool.network.StudentModel
import com.myoldschool.utils.SingleLiveEvent
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers

class MainActivityViewModel
@ViewModelInject
constructor(
    private val compositeDisposable: CompositeDisposable,
    private val apiRepository: ApiRepository
) : ViewModel() {

    val observeGetAllRecordsAPI = SingleLiveEvent<List<StudentModel>>()

    fun testInit() {
        if (compositeDisposable == null) {
            println("Not initialized")
        } else {
            println("Initialized")
        }
    }


    fun getAllRecords() {
        apiRepository.getAllRecords()
            .myApiSubscriber(MutableLiveData<Boolean>())
            .subscribe({
            observeGetAllRecordsAPI.postValue(it)
        },{it.printStackTrace()}).addTo(compositeDisposable)
    }


    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }

    private fun <T> Single<T>.myApiSubscriber(status: MutableLiveData<Boolean>?): Single<T> {
        return this.doOnSubscribe {
            status?.postValue(true)
        }.doFinally {
            status?.postValue(false)
        }.subscribeOn(Schedulers.io())
    }

}