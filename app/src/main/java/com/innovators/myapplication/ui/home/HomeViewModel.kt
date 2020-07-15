package com.innovators.myapplication.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innovators.myapplication.model.result.ResultsItem
import com.innovators.myapplication.repository.MovieRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel(private val movieRepository: MovieRepository) : ViewModel() {

    val disposable = CompositeDisposable()


    private val _popualarMoviesLiveData = MutableLiveData<List<ResultsItem>>()
    val popualarMoviesLiveData: LiveData<List<ResultsItem>> = _popualarMoviesLiveData

    init {
        getPopularMovies()
    }

    fun getPopularMovies(){

        disposable.add(
            movieRepository.getPopularMovies()

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response ->
                    _popualarMoviesLiveData.postValue(response.results)
                },{})
        )
    }
}