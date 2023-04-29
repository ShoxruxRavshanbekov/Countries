package uz.futuresoft.countries.presentation.screens.countries

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.futuresoft.countries.R
import uz.futuresoft.countries.databinding.CountryItemLayoutBinding
import uz.futuresoft.countries.domain.models.CountryModel

class CountriesAdapter(
    private val context: Context,
) :
    ListAdapter<CountryModel, CountriesAdapter.ViewHolder>(object :
        DiffUtil.ItemCallback<CountryModel>() {

        override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
            return oldItem.name == newItem.name
        }
    }) {

    @SuppressLint("SetTextI18n")
    inner class ViewHolder(private val binding: CountryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountryModel) {
            Glide.with(binding.root).load(item.flag).into(binding.countryFlag)
            binding.countryName.text = item.name
            binding.capital.text = "${context.getString(R.string.capital)} ${item.capital}"
            binding.population.text = "${context.getString(R.string.population)} ${item.population}"
            binding.language.text = "${context.getString(R.string.main_language)} ${item.language}"
            binding.region.text = "${context.getString(R.string.region)} ${item.region}"
            binding.subregion.text = "${context.getString(R.string.subregion)} ${item.subregion}"
            binding.timezone.text = "${context.getString(R.string.timezone)} ${item.timezone}"
            binding.startOfWeek.text =
                "${context.getString(R.string.start_of_week)} ${item.start_of_week}"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CountryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    interface ItemClickListener {
        fun onItemClicked(item: CountryModel)
    }
}