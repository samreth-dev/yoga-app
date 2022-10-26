package com.example.yoga

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.fragment_create_profile.*

class CreateProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val button = view?.findViewById<Button>(R.id.bnt_create)
        button?.setOnClickListener() {
            showAlert("Hello", "Testing")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_create_profile, container, false)

        val wmSpinner = view.findViewById<Spinner>(R.id.weight_metric_spinner)
        var wMetric = arrayOf("pounds", "kg")
        val wmAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, wMetric)
        wmSpinner.adapter = wmAdapter
        wmSpinner.setSelection(0)

        wmSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                (view as TextView).setTextColor(Color.WHITE)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        val hmSpinner = view.findViewById<Spinner>(R.id.height_metric_spinner)
        var hMetric = arrayOf("ft", "cm")
        val hmAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, hMetric)
        hmSpinner.adapter = hmAdapter
        hmSpinner.setSelection(0)

        hmSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                (view as TextView).setTextColor(Color.WHITE)
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        return view
    }

    private fun createProfile() {
        saveData()
        openMain()
    }

    private fun validateData() {
        createProfile()
    }

    private fun saveData() {
        val spf = context?.getSharedPreferences("miu_yoga", Context.MODE_PRIVATE)
        val spe = spf?.edit()
        spe?.apply()
    }

    private fun openMain() {
        val intent = Intent(activity, MainActivity::class.java)
        startActivity(intent)
    }

    private fun showAlert(title: String, message: String) {
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)

        builder.setNeutralButton("Maybe") { dialog, which ->

        }

        val alertDialog = builder.create()
        alertDialog.show()
    }
}