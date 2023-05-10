package uz.futuresoft.countries.presentation.screens.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import uz.futuresoft.countries.databinding.CountryItemLayoutBinding
import uz.futuresoft.countries.domain.models.CountryModel

class CountriesAdapter(
    private val itemClickListener: ClickListener,
) : ListAdapter<CountryModel, CountriesAdapter.ViewHolder>(
    object : DiffUtil.ItemCallback<CountryModel>() {

        override fun areItemsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: CountryModel, newItem: CountryModel): Boolean {
            return oldItem.common_name == newItem.common_name
        }
    }) {

    @SuppressLint("SetTextI18n")
    inner class ViewHolder(private val binding: CountryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CountryModel) {
            Glide.with(binding.root).load(item.flag).into(binding.countryFlag)
            binding.countryCommonName.text = item.common_name
            binding.countryOfficialName.text = item.official_name

            binding.root.setOnClickListener {
                itemClickListener.itemClickListener(item = item)
            }
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

    interface ClickListener {
        fun itemClickListener(item: CountryModel)
    }
}