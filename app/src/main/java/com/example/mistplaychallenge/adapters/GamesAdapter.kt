package com.example.mistplaychallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.mistplaychallenge.data.model.Games
import com.example.mistplaychallenge.databinding.ItemGameCardBinding

/**
 * Adapter responsible for providing the data for [Games]'s item
 */
class GamesAdapter(private val listOfGames: List<Games>) :
    RecyclerView.Adapter<GamesAdapter.GamesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val binding =
            ItemGameCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GamesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        holder.bind(listOfGames[position])
    }

    override fun getItemCount() = listOfGames.count()

    class GamesViewHolder(private val itemGameCardBinding: ItemGameCardBinding) :
        RecyclerView.ViewHolder(itemGameCardBinding.root) {
        fun bind(games: Games) {
            // bind data 
            with(itemGameCardBinding) {
                textviewGameTitle.text = games.title
                // COIL library used to load images 
                gameImageHolder.load(games.img)
            }
        }
    }
}
