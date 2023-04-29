package uz.futuresoft.countries.presentation.screens.countries

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.domain.usecases.GetAllCountriesUseCase
import javax.inject.Inject

@HiltViewModel
class CountriesViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase,
) : ViewModel() {

    private val _progress = MutableLiveData<Boolean>()
    val progress: LiveData<Boolean> = _progress

    private val _countries = MutableLiveData<CountryModel>()
    val countries: LiveData<CountryModel> = _countries

//    fun getAllCountries(): List<CountryModel> {
//        return getAllCountriesUseCase.invoke()
//    }

}