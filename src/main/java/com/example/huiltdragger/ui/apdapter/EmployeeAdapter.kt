package com.example.huiltdragger.ui.apdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.huiltdragger.R
import com.example.huiltdragger.model.Employee
import kotlinx.android.synthetic.main.employee_item.view.*


class EmployeeAdapter (private val callbackInterface:CallbackInterface): RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>() {

    inner class EmployeeViewHolder(itemView: View):RecyclerView.ViewHolder(itemView)


    private val diffCallback = object : DiffUtil.ItemCallback<Employee>(){
        override fun areItemsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Employee, newItem: Employee): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitList(list: List<Employee>) = differ.submitList(list)

    override fun onCreateViewHolder(
            parent: ViewGroup,
            viewType: Int
    ): EmployeeAdapter.EmployeeViewHolder {
        return EmployeeViewHolder(
                LayoutInflater.from(
                        parent.context
                ).inflate(
                        R.layout.employee_item,
                        parent,
                        false
                )
        )
    }


    override fun getItemCount(): Int {
        return differ.currentList.size
    }


    override fun onBindViewHolder(holder: EmployeeAdapter.EmployeeViewHolder, position: Int) {
        val item = differ.currentList[position]
        holder.itemView.apply {
            tvName.text = "${item.employee_name}"
            tvSalary.text = "Salary: Rs.${item.employee_salary}"
            tvAge.text = "Age: ${item.employee_age}"

            holder.itemView.setOnClickListener {
                callbackInterface.passDataCallback(item.employee_name.toString())
            }
        }

    }


    interface CallbackInterface {
        fun passDataCallback(message: String)
    }
}

