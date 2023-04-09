package com.udeni.firstsemesterend

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import com.udeni.firstsemesterend.repo.AppSharedPreference

class SettingsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_settings, container, false)
        val btnUpdate=view.findViewById<TextView>(R.id.btn_update)
        val txtUsername=view.findViewById<TextView>(R.id.edit_username)
        btnUpdate.setOnClickListener {
            AppSharedPreference(view.context).saveUser(txtUsername.text.trim().toString() ?: "")
            Toast.makeText(view.context,"User updated successfully.",Toast.LENGTH_SHORT).show()
            Log.d("LNBTI","Saved user")
        }
        return view

    }

}