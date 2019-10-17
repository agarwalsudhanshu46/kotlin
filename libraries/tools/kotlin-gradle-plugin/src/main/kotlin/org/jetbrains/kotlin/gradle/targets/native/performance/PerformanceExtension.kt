/*
 * Copyright 2010-2019 JetBrains s.r.o. and Kotlin Programming Language contributors.
 * Use of this source code is governed by the Apache 2.0 license that can be found in the license/LICENSE.txt file.
 */

package org.jetbrains.kotlin.gradle.plugin.performance

import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.jetbrains.kotlin.gradle.plugin.mpp.NativeBinary

enum class TrackableMetric { COMPILE_TIME, CODE_SIZE }
open class PerformanceExtension(private val project: Project) {
    @get:Input
    val version: String
        get() = project.version.toString()

    @Optional
    @Input
    var metrics = listOf(TrackableMetric.COMPILE_TIME, TrackableMetric.CODE_SIZE)

    @Input
    var trackedBinaries: List<NativeBinary> = emptyList()

    @Optional
    @Input
    var binaryNamesForReport = mapOf<NativeBinary, String>()
}