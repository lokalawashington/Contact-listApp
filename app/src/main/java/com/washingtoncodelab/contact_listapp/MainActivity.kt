package com.washingtoncodelab.contact_listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import com.washingtoncodelab.contact_listapp.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val  adapter = ContactAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
    }
    private fun setUpData(binding: ActivityMainBinding) {
        binding.contactsRV.adapter = adapter
        binding.contactsRV.addItemDecoration(DividerItemDecoration(this,LinearLayout.VERTICAL))
        val builder = AlertDialog.Builder(this)
        val inflater = this.layoutInflater
        val view = inflater.inflate(R.layout.add_contact_dialog,
            null)
        builder.setView(view)

        var name = view.findViewById<TextView>(R.id.nameET)
        var no = findViewById<TextView>(R.id.numberTI)
        var save = findViewById<TextView>(R.id.saveBt)
        no.addTextChangedListener(object:TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                save.isEnabled = s?.length == 11
            }

            override fun afterTextChanged(s: Editable?) {

            }

        })
        val alertDialog = builder.create()
        save.setOnClickListener {
            val contact = Contact(name.text.toString(),no.text.toString())
            val contacts = mutableListOf(contact)
            adapter.setupContact(contacts)
            alertDialog.dismiss()
        }


        binding.fab.setOnClickListener {
            alertDialog.show()
        }
    }
}