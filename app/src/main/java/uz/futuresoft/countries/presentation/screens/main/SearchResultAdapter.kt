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

class SearchResultAdapter(
    private val itemClickListener: ClickListener,
    private val list: List<CountryModel>,
) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CountryItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CountryItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        Glide.with(holder.binding.root).load(item.flag).into(holder.binding.countryFlag)
        holder.binding.countryCommonName.text = item.common_name
        holder.binding.countryOfficialName.text = item.official_name

        holder.binding.root.setOnClickListener {
            itemClickListener.foundItemClickListener(item = item)
        }
    }

    override fun getItemCount(): Int = list.size

    interface ClickListener {
        fun foundItemClickListener(item: CountryModel)
    }
}