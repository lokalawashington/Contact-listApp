package com.washingtoncodelab.contact_listapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.washingtoncodelab.contact_listapp.databinding.ContactListItemBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ContactViewHolder>(){
    private val contacts = mutableListOf<Contact>()
    inner class  ContactViewHolder(private val binding:
                                   ContactListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bindItem(contact:Contact){
           binding.nameTV.text = contact.name
            binding.numberTV.text = contact.number
        }
    }
    fun setupContact(contact:List<Contact>) {
        this.contacts.addAll(contacts)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        return  ContactViewHolder(ContactListItemBinding.
         inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bindItem(contact)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}