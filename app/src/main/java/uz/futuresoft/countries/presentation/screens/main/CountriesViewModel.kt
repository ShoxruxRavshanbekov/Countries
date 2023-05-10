package uz.futuresoft.countries.presentation.screens.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.usecases.GetAllCountriesUseCase
import uz.futuresoft.countries.domain.usecases.SearchCountryUseCase
import uz.futuresoft.countries.domain.utils.ResponseResult
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
    private val searchCountryUseCase: SearchCountryUseCase,
) : ViewModel() {

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    private val _noDataAvailable = MutableLiveData<Boolean>()
    val noDataAvailable: LiveData<Boolean> = _noDataAvailable

    private val _searchDataIsNotAvailable = MutableLiveData<Boolean>()
    val searchDataIsNotAvailable: LiveData<Boolean> = _searchDataIsNotAvailable

    private val _searchOrderIsEmpty = MutableLiveData<Boolean>()
    val searchOrderIsEmpty: LiveData<Boolean> = _searchOrderIsEmpty

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    private val _countriesData = MutableLiveData<List<CountryModel>>()
    val countriesData: LiveData<List<CountryModel>> = _countriesData

    private val _searchResult = MutableLiveData<List<CountryModel>>()
    val searchResult: LiveData<List<CountryModel>> = _searchResult

    init {
        _progress.value = true

        viewModelScope.launch {
            getAllCountriesUseCase.invoke().collect {
                _progress.value = false

                when (it) {
                    is ResponseResult.Success -> {
                        val data = it.data
                        if (data.isNotEmpty()) {
                            _noDataAvailable.value = false
                            _countriesData.value = data
                        } else {
                            _noDataAvailable.value = true
                        }
                    }

                    is ResponseResult.Error -> {
                        _error.value = "${it.error.message}"
                    }
                }
            }
        }
    }

    fun searchCountry(data: String) {
        viewModelScope.launch {
            searchCountryUseCase.invoke(data).collect {

                if (data != "") {
                    _searchOrderIsEmpty.value = false

                    if (it.isNotEmpty()) {
                        _searchResult.value = it
                        _searchDataIsNotAvailable.value = false
                    } else {
                        _searchDataIsNotAvailable.value = true
                    }
                } else {
                    _searchOrderIsEmpty.value = true
                }
            }
        }
    }
}