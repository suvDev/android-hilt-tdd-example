package com.myoldschool.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

class MainActivityViewModel
@ViewModelInject
constructor(
    private val compositeDisposable: CompositeDisposable
): ViewModel() {

    fun testInit(){
        if(compositeDisposable==null){
            println("Not initialized")
        }else{
            println("Initialized")
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

}