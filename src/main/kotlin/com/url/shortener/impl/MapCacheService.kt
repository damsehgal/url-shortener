package com.url.shortener.impl

import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse
import com.url.shortener.service.CacheService

class MapCacheService : CacheService {

    var encodedRequestMap: HashMap<EncodeRequest, EncodeResponse> = HashMap()
    var decodedRequestMap: HashMap<DecodeRequest, DecodeResponse> = HashMap()

    override fun contains(encodeRequest: EncodeRequest): Boolean {
        return encodedRequestMap.containsKey(encodeRequest)
    }

    override fun contains(decodeRequest: DecodeRequest): Boolean {
        return decodedRequestMap.containsKey(decodeRequest)
    }

    override fun getFromCache(encodeRequest: EncodeRequest): EncodeResponse {
        return encodedRequestMap[encodeRequest]!!
    }

    override fun getFromCache(decodeRequest: DecodeRequest): DecodeResponse {
        return decodedRequestMap[decodeRequest]!!
    }

    override fun add(encodeRequest: EncodeRequest, encodeResponse: EncodeResponse) {
        encodedRequestMap[encodeRequest] = encodeResponse
    }

    override fun add(decodeRequest: DecodeRequest, decodeResponse: DecodeResponse) {
        decodedRequestMap[decodeRequest] = decodeResponse
    }

}