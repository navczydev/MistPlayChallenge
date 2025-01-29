package com.example.mistplaychallenge.presentation.ui.mappers

interface UIMapper<E, V> {
    fun mapToView(input: E): V
}