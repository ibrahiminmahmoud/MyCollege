/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.mycollege.data

import com.example.mycollege.R
import com.example.mycollege.data.model.Lec


object DataProvider {

    val lec =
        Lec(
            id = 1,
            title = "Monty",
            description = "Monty enjoys chicken treats and cuddling while watching Seinfeld.",
            lecId = R.raw.des
        )

    val leclist = listOf(
        lec,
        Lec(
            id = 2,
            title = "Jubilee",
            description = "Jubilee enjoys thoughtful discussions by the campfire.",
            lecId = R.raw.samplepdf
        ),
        Lec(
            id = 3,
            title = "Beezy",

            description = "Beezy's favorite past-time is helping you choose your brand color.",
            lecId = R.raw.lecture9
        ),

    )
}
