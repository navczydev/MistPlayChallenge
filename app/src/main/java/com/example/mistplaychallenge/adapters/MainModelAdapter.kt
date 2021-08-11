package com.example.mistplaychallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mistplaychallenge.data.model.MainModel
import com.example.mistplaychallenge.databinding.ItemMainModelBinding

/**
 * Adapter responsible for providing the data for [MainModel]'s item
 * @author Nav Singh
 */
class MainModelAdapter(private val listOfMainModel: List<MainModel>) :
    RecyclerView.Adapter<MainModelAdapter.MainModelViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainModelViewHolder {
        val binding =
            ItemMainModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainModelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainModelViewHolder, position: Int) {
        holder.bind(listOfMainModel[position])
    }

    override fun getItemCount() = listOfMainModel.count()

    class MainModelViewHolder(private val itemMainModelBinding: ItemMainModelBinding) :
        RecyclerView.ViewHolder(itemMainModelBinding.root) {
        // binding data to the UI components done here.
        fun bind(mainModel: MainModel) {
            with(itemMainModelBinding) {
                textviewGameCategoryTitle.text = mainModel.listTitle
                listGames.apply {
                    layoutManager = LinearLayoutManager(
                        itemMainModelBinding.root.context,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = GamesAdapter(mainModel.games)
                }
            }
        }
    }
}
