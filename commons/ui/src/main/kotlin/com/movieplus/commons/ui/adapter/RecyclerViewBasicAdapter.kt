package com.movieplus.commons.ui.adapter
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

class RecyclerViewBasicAdapter<T>(
    private val viewBindingHandler: () -> ViewBinding,
    private val bindHandler: ((ViewBinding, T?) -> Unit)? = null,
    private val itemSelectedHandler: ((T) -> Unit)? = null
) : RecyclerView.Adapter<RecyclerViewBasicAdapter<T>.ViewHolder>() {

    var list: List<T> = arrayListOf()

    //region Override

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(viewBindingHandler())
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.root.setOnClickListener { itemSelectedHandler?.invoke(list[position]) }
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    //endregion

    //region ViewHolder

    inner class ViewHolder constructor(val binding: ViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: T?) {
            bindHandler?.invoke(binding, item)
        }
    }

    //endregion
}

