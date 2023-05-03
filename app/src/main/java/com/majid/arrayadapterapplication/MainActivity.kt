package com.majid.arrayadapterapplication

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.majid.arrayadapterapplication.databinding.ActivityMainBinding
import com.majid.arrayadapterapplication.databinding.CustomDialogBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var arrayAdapter: ArrayAdapter<String>
    private var Array = arrayListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,Array)
        binding.lvist.adapter=arrayAdapter

        binding.fab1.setOnClickListener {
            var dialog = Dialog(this)
            val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
            dialog.setContentView(dialogBinding.root)
            dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
            dialog.show()
            dialogBinding.btnadd.setOnClickListener {
                if (dialogBinding.etnames.text.toString().isEmpty())
                {
                    dialogBinding.etnames.error="Enter Name"
                }
                else{
                    Array.add(dialogBinding.etnames.text.toString())
                dialog.dismiss()

            }

            arrayAdapter.notifyDataSetChanged()
        }
            dialogBinding.btncancel.setOnClickListener {
                dialog.dismiss()
            }
    }
}}