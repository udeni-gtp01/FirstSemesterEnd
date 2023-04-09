package com.udeni.firstsemesterend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.udeni.firstsemesterend.databinding.FragmentHomeBinding
import com.udeni.firstsemesterend.repo.AppSharedPreference
import com.udeni.firstsemesterend.viewmodel.UserViewModel

class HomeFragment : Fragment() {
    val viewModel: UserViewModel by viewModels()
    lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val label = view.findViewById<TextView>(R.id.btn_settings)
        val txtWelcome = view.findViewById<TextView>(R.id.txt_welcome)

        val savedUsername = AppSharedPreference(view.context).getUsername()
        txtWelcome.text = "Welcome ${savedUsername}"
        label.setOnClickListener {
            navigateToSettings()
        }
        return view
    }

    private fun navigateToSettings() {
        val navController = findNavController()
        navController.navigate(R.id.action_homeFragment_to_settingsFragment)
    }
}