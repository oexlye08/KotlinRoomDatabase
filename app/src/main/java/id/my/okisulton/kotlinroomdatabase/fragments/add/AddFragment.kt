package id.my.okisulton.kotlinroomdatabase.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import id.my.okisulton.kotlinroomdatabase.R
import id.my.okisulton.kotlinroomdatabase.model.User
import id.my.okisulton.kotlinroomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.add_button.setOnClickListener {
            insertDatatoDatabase()
        }

        return view
    }

    private fun insertDatatoDatabase() {
        val firstName = firstname.text.toString()
        val lastName = lastname.text.toString()
        val age = age.text

        if (inputCheck(firstName, lastName, age)){
            //Create User Object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))

            //add data to db
            mUserViewModel.adduser(user)
            Toast.makeText(requireContext(), "Success", Toast.LENGTH_LONG).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

}