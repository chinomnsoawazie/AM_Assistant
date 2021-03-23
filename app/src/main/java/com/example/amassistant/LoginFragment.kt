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
import com.example.amassistant.databinding.FragmentLoginBinding

/**
 */
class LoginFragment : Fragment() {

    // Binding object instance corresponding to the fragment_login.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentBinding = FragmentLoginBinding.inflate(inflater, container, false)
        binding = fragmentBinding
        return fragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginViewModel  = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        binding.loginFragment = this
        binding.login.setOnClickListener{goToUserPage()}


    }

    /**
     * Navigate back to start screen.
     */
    fun goToUserPage() {
        val userName = binding.username.text.toString()
        val password = binding.password.text.toString()
        Log.d("UserInfo", "Email: ${userName}" + "Password: ${password}")
        //logic for login here

        //navigate to user screen on successful login
        findNavController().navigate(R.id.action_loginFragment_to_userFragment)
    }

    /**
     * Cancel the login and start over.
     */
    fun cancelLogin() {
        // Navigate back to the [StartFragment] to start over
        findNavController().navigate(R.id.action_loginFragment_to_startFragment)
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
    override fun onDestroyView() {
        super.onDestroyView()
//        binding = null
    }
}