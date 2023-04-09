package com.udeni.firstsemesterend

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udeni.firstsemesterend.repo.AppSharedPreference

class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin = view.findViewById<TextView>(R.id.btn_login)
        val txtUsername = view.findViewById<TextView>(R.id.txt_username)
        val txtPassword = view.findViewById<TextView>(R.id.txt_password)

        val savedUsername = AppSharedPreference(view.context).getUsername()
        txtUsername.text = savedUsername

        btnLogin.setOnClickListener {
            Log.d("LNBTI", "User is ${txtUsername.text} and ${txtPassword.text}")
            if (txtUsername.text.toString().trim() == "admin" && txtPassword.text.toString()
                    .trim() == "password"
            )
                navigateToHome()
            else
                Toast.makeText(context, "Invalid username or password", Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private fun navigateToHome() {
        val navController = findNavController()
        navController.navigate(R.id.action_loginFragment_to_homeFragment)
    }
}