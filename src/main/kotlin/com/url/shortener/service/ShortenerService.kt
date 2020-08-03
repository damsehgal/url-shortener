package com.url.shortener.service

import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse


interface ShortenerService {
    fun encode (encodeRequest: EncodeRequest): EncodeResponse
    fun decode (decodeRequest: DecodeRequest): DecodeResponse
}