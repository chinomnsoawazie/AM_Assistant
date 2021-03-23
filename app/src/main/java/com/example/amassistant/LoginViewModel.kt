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

import androidx.lifecycle.ViewModel

/**
 */
class LoginViewModel : ViewModel() {

    // Binding object instance corresponding to the fragment_login.xml layout
    // This property is non-null between the onCreateView() and onDestroyView() lifecycle callbacks,
    // when the view hierarchy is attached to the fragment.


    /**
     * Navigate back to start screen.
     */
    fun goToUserPage() {
        //logic for login here

        //navigate to user screen on successful login
    }

    /**
     * Cancel the login and start over.
     */
    fun cancelLogin() {
        // Navigate back to the [StartFragment] to start over
    }

    /**
     * This fragment lifecycle method is called when the view hierarchy associated with the fragment
     * is being removed. As a result, clear out the binding object.
     */
}