package uz.futuresoft.countries.presentation.screens.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.core.view.GravityCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import uz.futuresoft.countries.databinding.ScreenCountriesBinding
import uz.futuresoft.countries.domain.models.CountryModel
import uz.futuresoft.countries.presentation.screens.main.dialogues.BottomSheetDialog
import uz.futuresoft.countries.utils.showToast

@AndroidEntryPoint
class CountriesScreen : Fragment(), CountriesAdapter.ClickListener,
    SearchResultAdapter.ClickListener, TextWatcher {

    private val binding: ScreenCountriesBinding by lazy {
        ScreenCountriesBinding.inflate(
            layoutInflater
        )
    }
    private lateinit var dataAdapter: CountriesAdapter
    private lateinit var searchResultAdapter: CountriesAdapter
    private lateinit var bottomSheetDialog: BottomSheetDialog
    private val viewModel: CountriesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAdapter = CountriesAdapter(itemClickListener = this)
        searchResultAdapter = CountriesAdapter(itemClickListener = this)
        binding.countriesRecyclerView.adapter = dataAdapter
        binding.searchResultRecyclerView.adapter = searchResultAdapter
        binding.searchTIE.addTextChangedListener(this)
        observers()
        onBackPressed()
    }

    private fun observers() {
        viewModel.error.observe(viewLifecycleOwner, errorObserver)
        viewModel.progress.observe(viewLifecycleOwner, progressObserver)
        viewModel.noDataAvailable.observe(viewLifecycleOwner, noDataAvailableObserver)
        viewModel.searchDataIsNotAvailable.observe(
            viewLifecycleOwner,
            searchDataIsNotAvailableObserver
        )
        viewModel.searchOrderIsEmpty.observe(viewLifecycleOwner, searchOrderIsEmptyObserver)
        viewModel.countriesData.observe(viewLifecycleOwner, countriesDataObserver)
        viewModel.searchResult.observe(viewLifecycleOwner, searchResultObserver)
    }

    override fun itemClickListener(item: CountryModel) {
        bottomSheetDialog = BottomSheetDialog(data = item)
        bottomSheetDialog.show(childFragmentManager, BottomSheetDialog.TAG)
    }

    override fun foundItemClickListener(item: CountryModel) {
        bottomSheetDialog = BottomSheetDialog(data = item)
        bottomSheetDialog.show(childFragmentManager, BottomSheetDialog.TAG)
    }

    private fun onBackPressed() {
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (binding.searchTIL.isFocused || binding.searchTIE.text!!.isNotEmpty()) {
                    binding.searchTIE.text?.clear()
                    binding.searchTIL.clearFocus()
                } else {
                    requireActivity().finish()
                }
            }
        }
        activity?.onBackPressedDispatcher?.addCallback(viewLifecycleOwner, callback)
    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        viewModel.searchCountry(p0.toString())
    }

    override fun afterTextChanged(p0: Editable?) {}
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    private val errorObserver = Observer<String> {
//        showToast(context = requireContext(), message = it)
    }

    private val progressObserver = Observer<Boolean> {
        binding.progressIndicator.isVisible = it
    }

    private val noDataAvailableObserver = Observer<Boolean> {
        if (it) {
            binding.countriesRecyclerView.isGone = true
            binding.ifDataIsNotFound.isVisible = true
        } else {
            binding.countriesRecyclerView.isVisible = true
            binding.ifDataIsNotFound.isGone = true
        }
    }

    private val searchDataIsNotAvailableObserver = Observer<Boolean> {
        if (it) {
            binding.countriesRecyclerView.isGone = true
            binding.searchResultRecyclerView.isGone = true
            binding.ifDataIsNotFound.isVisible = true
        } else {
            binding.countriesRecyclerView.isGone = true
            binding.searchResultRecyclerView.isVisible = true
            binding.ifDataIsNotFound.isGone = true
        }
    }

    private val searchOrderIsEmptyObserver = Observer<Boolean> {
        if (it) {
            binding.countriesRecyclerView.isVisible = true
            binding.searchResultRecyclerView.isGone = true
            binding.ifDataIsNotFound.isGone = true
        } else {
            binding.countriesRecyclerView.isGone = true
            binding.searchResultRecyclerView.isVisible = true
            binding.ifDataIsNotFound.isGone = true
        }
    }

    private val countriesDataObserver = Observer<List<CountryModel>> {
        dataAdapter.submitList(it)
    }

    private val searchResultObserver = Observer<List<CountryModel>> {
        searchResultAdapter.submitList(it)
    }
}