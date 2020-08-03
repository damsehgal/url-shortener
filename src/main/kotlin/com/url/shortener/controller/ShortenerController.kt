package com.url.shortener.controller

import com.url.shortener.dam.ShortenerDataManager
import com.url.shortener.model.DecodeRequest
import com.url.shortener.model.DecodeResponse
import com.url.shortener.model.EncodeRequest
import com.url.shortener.model.EncodeResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shortenerController")
class ShortenerController {

    @Autowired
    private lateinit var shortenerDataManager: ShortenerDataManager

    @RequestMapping(value = ["/encode"], method = [RequestMethod.POST])
    fun encode(@RequestBody encodeRequest: EncodeRequest): EncodeResponse {
        return shortenerDataManager.encode(encodeRequest);
    }

    @RequestMapping(value = ["/decode"], method = [RequestMethod.POST])
    fun decode(@RequestBody decodeRequest : DecodeRequest)  : DecodeResponse {
        return shortenerDataManager.decode(decodeRequest);
    }
}