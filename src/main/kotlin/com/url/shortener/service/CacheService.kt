package com.url.shortener.service

import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse


interface CacheService {
    fun contains (encodeRequest: EncodeRequest) : Boolean
    fun contains (decodeRequest: DecodeRequest) : Boolean
    fun getFromCache (encodeRequest: EncodeRequest) : EncodeResponse
    fun getFromCache (decodeRequest: DecodeRequest) : DecodeResponse
    fun add (encodeRequest: EncodeRequest, encodeResponse: EncodeResponse)
    fun add (decodeRequest: DecodeRequest, decodeResponse: DecodeResponse)

}