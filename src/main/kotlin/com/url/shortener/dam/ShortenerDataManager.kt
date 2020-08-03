package com.url.shortener.dam

import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse
import com.url.shortener.service.CacheService
import com.url.shortener.service.ShortenerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShortenerDataManager {
    @Autowired
    private lateinit var shortenerService: ShortenerService

    @Autowired
    private lateinit var cacheService: CacheService

    fun encode(encodeRequest: EncodeRequest): EncodeResponse {
        if (cacheService.contains(encodeRequest)) {
            return cacheService.getFromCache(encodeRequest)
        }

        val encodeResponse = shortenerService.encode(encodeRequest);
        cacheService.add(encodeRequest, encodeResponse)
        return encodeResponse
    }

    fun decode(decodeRequest: DecodeRequest): DecodeResponse {
        if (cacheService.contains(decodeRequest)) {
            return cacheService.getFromCache(decodeRequest)
        }
        val decodeResponse = shortenerService.decode(decodeRequest);
        cacheService.add(decodeRequest, decodeResponse)
        return decodeResponse
    }
}