package vocs.listinone.ui.lists

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_mainlist.view.*
import vocs.listinone.R
import vocs.listinone.model.MainListItemData

class MainListAdapter(val items: ArrayList<MainListItemData>, val context: Context)
    : RecyclerView.Adapter<ViewHolderMainList>() {

    var elementChanging = ""
    var newText = ""
    var itemsSelected = ArrayList<MainListItemData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderMainList {
        return ViewHolderMainList(LayoutInflater.from(context).inflate(R.layout.item_mainlist, parent, false))
    }

    override fun getItemCount(): Int { return items.size }
    
    override fun onBindViewHolder(holder: ViewHolderMainList, position: Int) {
        holder?.bindItems(items[position])
    }

    override fun onBindViewHolder(holder: ViewHolderMainList, position: Int, payloads: MutableList<Any>) {

        holder.deactivating()

        if (payloads.isEmpty()) {
            holder.itemView.requestFocus()

            if (itemsSelected.contains(items[position])){
              holder.activateRow()
            } else {
                holder.deactivating()
                holder.deactivateRow()
            }
            onBindViewHolder(holder, position)

        } else {
            when (payloads[0]) {
                /*TITULO.name -> {
                    holder.activateElementName()
                    items[position].name = newText
                }

                DESCRIPCION.name -> {
                    holder.activateElementDesc()
                    items[position].description = newText
                }

                STATUS.name -> {
                    holder.itemView. .isActivated = true
                    items[position].description = newText
                }

                TIPO.name -> {
                    holder.itemView.tv_desc.isActivated = true
                    items[position].description = newText
                }*/
            }

            //STATUS.name -> holder?.setTitle(title)
            //TIPO.name -> holder?.setTitle(title)
        }
        super.onBindViewHolder(holder, position, payloads)
    }

    fun insert(position: Int, item: MainListItemData, element: String) {
        items.add(position, item)
        elementChanging = element
        itemsSelected.clear()
        itemsSelected.add(items[position])

        deactivateUnselectedRows()
        notifyItemInserted(position)
    }

    fun deactivateView(position: Int) {
        notifyItemChanged(position)
    }

    fun updateInfo(position: Int, text: String) {
        newText = text
        notifyItemChanged(position, elementChanging)
    }

    fun activateElement(position: Int, element: String) {
        elementChanging = element
        notifyItemChanged(position, elementChanging)
    }

    fun removeByItem(item: MainListItemData) {
        val position = items.indexOf(item)
        items.remove(item)
        notifyItemRemoved(position)
    }

    fun removeByPosition(position: Int) {
        notifyItemRemoved(position)
    }

    /*fun selectItem(position: Int) {
        positionSelected = position
        deactivateUnselectedRows()
    }*/

    fun selectItems(itemsSelected: ArrayList<MainListItemData>) {
        this.itemsSelected.clear()
        this.itemsSelected.addAll(itemsSelected)
        deactivateUnselectedRows()
    }

    private fun deactivateUnselectedRows() {
        var index = 0
        items.forEach { _ ->
            notifyItemChanged(index++)
        }
    }
}

class ViewHolderMainList(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {

    fun bindItems(item: MainListItemData) {
        itemView.tv_name.text = item.name
        itemView.tv_desc.text = item.description
    }

    fun deactivating() {
        itemView.isActivated = false
        itemView.clearFocus()
        itemView.tv_name.isActivated = false
        itemView.tv_desc.isActivated = false
        itemView.userImg.isActivated = false
        itemView.iv_status.isActivated = false
    }

    fun activateRow() {
        itemView.requestFocus()
        itemView.singleRow.isSelected = true
        itemView.tv_name.isSelected = false
        itemView.tv_desc.isSelected = false
        itemView.userImg.isSelected = false
        itemView.iv_status.isSelected = false
    }

    fun deactivateRow() {
        itemView.clearFocus()
        itemView.singleRow.isSelected = false
    }

    fun activateElementName() {
        itemView.tv_name.isActivated = true
        itemView.tv_desc.clearFocus()
        itemView.userImg.clearFocus()
        itemView.iv_status.clearFocus()
    }

    fun activateElementDesc() {
        itemView.tv_name.clearFocus()
        itemView.tv_desc.isActivated = true
        itemView.userImg.clearFocus()
        itemView.iv_status.clearFocus()
    }
    fun activateElementUserImg() {
        itemView.tv_name.clearFocus()
        itemView.tv_desc.clearFocus()
        itemView.userImg.isActivated = true
        itemView.iv_status.clearFocus()
    }
    fun activateElementStatus() {
        itemView.tv_name.clearFocus()
        itemView.tv_desc.clearFocus()
        itemView.userImg.clearFocus()
        itemView.iv_status.isActivated = true
    }

}