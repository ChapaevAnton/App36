package com.w4eret1ckrtb1tch.app36.multibindings

import javax.inject.Qualifier

interface FormatExporter

class XmlFormatExporter : FormatExporter
class CsvFormatExporter : FormatExporter


interface Feature {
    fun getString(): String
}

class FeatureImplOne : Feature {
    override fun getString(): String {
        return "FeatureImplOne"
    }
}

class FeatureImplTwo : Feature {
    override fun getString(): String {
        return "FeatureImplTwo"
    }
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class One

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Two