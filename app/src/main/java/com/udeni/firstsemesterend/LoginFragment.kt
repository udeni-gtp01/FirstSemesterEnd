package com.udeni.firstsemesterend

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.udeni.firstsemesterend.repo.AppSharedPreference

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_login, container, false)
        val btnLogin=view.findViewById<TextView>(R.id.btn_login)
        val txtUsername=view.findViewById<TextView>(R.id.txt_username)
        val txtPassword=view.findViewById<TextView>(R.id.txt_password)

        val savedUsername = AppSharedPreference(view.context).getUsername()
        txtUsername.text=savedUsername

        btnLogin.setOnClickListener {
            Log.d("LNBTI","User is ${txtUsername.text} and ${txtPassword.text}")
           if(txtUsername.text.toString().trim()=="admin" && txtPassword.text.toString().trim()=="password")
               navigateToHome()
           else
               Toast.makeText(context,"Invalid username or password",Toast.LENGTH_SHORT).show()
        }
        return view
    }

    private fun navigateToHome() {
        val navController=findNavController()
        navController.navigate(R.id.action_loginFragment_to_homeFragment)
    }
}