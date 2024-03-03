package com.graduation.mawruth.ui.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.graduation.breastcancer.data.ModelResults
import com.graduation.breastcancer.data.UserData
import com.graduation.breastcancer.databinding.ReportItemBinding


class ReportsAdapter(
    private var list: List<UserData>?,
    private var modelResults: List<ModelResults>?
) :
    RecyclerView.Adapter<ReportsAdapter.ViewHolder>() {

    class ViewHolder(val itemBinding: ReportItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding =
            ReportItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    fun bindMuseumsList(list: List<UserData>?, modelResultList: List<ModelResults>?) {
        this.list = list
        this.modelResults = modelResultList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list!!.size
    }

    fun interface onItemClick {
        fun onClick(pos: Int, item: UserData, modelResult: ModelResults)
    }

    var onItemClickListener: onItemClick? = null

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list?.get(position)
        val modelItem = modelResults?.get(position)
        holder.itemBinding.userNameTV.text = item?.userName
        holder.itemBinding.ageTV.text = item?.age
        holder.itemBinding.cancerResTV.text = modelItem?.modelRes

        onItemClickListener.let { onItemClick ->
            holder.itemView.rootView.setOnClickListener {
                onItemClick?.onClick(
                    position, list?.get(position)!!,
                    modelResults?.get(position)!!
                )
            }

        }


    }
}