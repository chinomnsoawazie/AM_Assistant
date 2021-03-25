/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.amassistant

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.amassistant.databinding.FragmentSignupBinding
import com.google.firebase.auth.FirebaseAuth


/**
 */
class SignupFragment : Fragment() {

    // Binding object instance corresponding to the fragment_signup.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private var binding: FragmentSignupBinding? = null

    private val mAuth: FirebaseAuth? = null

    private val viewModel: SignupViewModel by viewModels()

    override fun  onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        FirebaseAuth.getInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentSignupBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.signupFragment  = this
        binding?.lifecycleOwner = viewLifecycleOwner
        binding?.createAccount?.setOnClickListener{createAccount()}

    }

    /**
     */
    fun cancelSignup() {
        // Navigate to home screen
        findNavController().navigate(R.id.action_signUp_to_startFragment)
    }

    fun createAccount() {
        val emailInput = binding?.username?.text.toString()
        val passwordInput = binding?.password?.text.toString()
        Log.d("SignupInfo", "Email: ${emailInput}" + "Password: ${passwordInput}")
        viewModel.createUser(emailInput, passwordInput)



        //Account creation logic here

        // Navigate to home screen after submission of account creation details
        findNavController().navigate(R.id.action_signUp_to_startFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}