package id.my.okisulton.kotlinroomdatabase.fragments.update

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import id.my.okisulton.kotlinroomdatabase.R
import id.my.okisulton.kotlinroomdatabase.model.User
import id.my.okisulton.kotlinroomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.update_firstname.setText(args.currentUser.firstName)
        view.update_lastname.setText(args.currentUser.lastName)
        view.update_age.setText(args.currentUser.age.toString())

        view.update_button.setOnClickListener {
            updateItem()
        }

        //add menu
        setHasOptionsMenu(true)

        return view
    }

    private fun updateItem() {
        val firstName = update_firstname.text.toString()
        val lastName = update_lastname.text.toString()
        val age = Integer.parseInt(update_age.text.toString())

        if (inputCheck(firstName, lastName, update_age.text)){
            //create object
            val updateUser = User(args.currentUser.id, firstName, lastName, age)

            //Update current user
            mUserViewModel.updateuser(updateUser)
            Toast.makeText(requireContext(), "Update successfully", Toast.LENGTH_SHORT).show()

            //navigate back
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.item_delete){
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Yes"){_, _ ->
            mUserViewModel.deleteuser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully delete ${args.currentUser.firstName}", Toast.LENGTH_SHORT).show()

            //back to list
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        }
        builder.setNegativeButton("No"){_, _->}
        builder.setTitle("Delete ${args.currentUser.firstName}?")
        builder.setMessage("Are you sure want to delete ${args.currentUser.firstName}")
        builder.create().show()
    }
}