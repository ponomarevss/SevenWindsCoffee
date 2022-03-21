package ru.ponomarevss.sevenwindscoffee.model.image

interface IImageLoader<T> {
    fun loadInto(url: String, container: T)
}