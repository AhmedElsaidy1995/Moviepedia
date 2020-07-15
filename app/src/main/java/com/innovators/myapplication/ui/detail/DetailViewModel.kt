package com.innovators.myapplication.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.innovators.myapplication.model.cast.CastItem
import com.innovators.myapplication.model.result.ResultsItem
import com.innovators.myapplication.model.trailer.TrailerItem
import com.innovators.myapplication.repository.MovieRepository
import com.innovators.myapplication.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailViewModel (private val movieRepository: MovieRepository) : BaseViewModel() {

    private val _castLiveData = MutableLiveData<List<CastItem>>()
    val castLiveData: LiveData<List<CastItem>> = _castLiveData

    private val _trailerLiveData = MutableLiveData<List<TrailerItem>>()
    val trailerLiveData: LiveData<List<TrailerItem>> = _trailerLiveData



    fun getMoviesCast(id:String){

        disposable.add(
            movieRepository.getCastMovies(id)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response ->
                    _castLiveData.postValue(response.cast)
                },{})
        )
    }

    fun getMoviesTrailer(id:String){

        disposable.add(
            movieRepository.getMoviesTrailer(id)

                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({response ->
                    _trailerLiveData.postValue(response.results)
                },{})
        )
    }
}