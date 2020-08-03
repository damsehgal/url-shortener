package com.url.shortener

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.url.shortener"])
class UrlShortenerApplication

fun main(args: Array<String>) {
	runApplication<UrlShortenerApplication>(*args)
}
