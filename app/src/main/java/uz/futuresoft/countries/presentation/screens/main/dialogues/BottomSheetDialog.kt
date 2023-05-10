package uz.futuresoft.countries.presentation.screens.main.dialogues

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import uz.futuresoft.countries.R
import uz.futuresoft.countries.databinding.BottomSheetDialogBinding
import uz.futuresoft.countries.domain.models.CountryModel

class BottomSheetDialog(
    private val data: CountryModel,
) : BottomSheetDialogFragment() {

    private lateinit var binding: BottomSheetDialogBinding

    companion object {
        const val TAG = "BottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = BottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData(data)
    }

    @SuppressLint("SetTextI18n")
    private fun initData(data: CountryModel) {
        Glide.with(binding.root).load(data.flag).into(binding.countryFlag)
        binding.countryCommonName.text = data.common_name
        binding.countryOfficialName.text = data.official_name
        binding.capital.text =
            "${binding.root.context.getString(R.string.capital)} ${data.capital[0]}"
        binding.population.text =
            "${binding.root.context.getString(R.string.population)} ${data.population}"
        binding.region.text = "${binding.root.context.getString(R.string.region)} ${data.region}"
        binding.subregion.text =
            "${binding.root.context.getString(R.string.subregion)} ${data.subregion}"
        binding.timezone.text =
            "${binding.root.context.getString(R.string.timezone)} ${data.timezone[0]}"
        binding.startOfWeek.text =
            "${binding.root.context.getString(R.string.start_of_week)} ${data.start_of_week}"
    }
}