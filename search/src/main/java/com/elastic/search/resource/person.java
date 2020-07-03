package com.elastic.search.resource;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;

import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.InetAddress;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

@RestController
@RequestMapping("rest/product")
public class person {

    @GetMapping("/get")
    public String get() throws IOException {
        TransportClient client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("localhost"),9300));
        IndexResponse response = client.prepareIndex("product","_doc")
            .setSource(jsonBuilder()
            .startObject()
            .field("name", "Vasu")
            .field("roll",100)
            .endObject()
            )
            .get();
      return response.getResult().toString();
    }
}


//@RestController
//class ErrorHandlerController implements ErrorController {
//
//    @Override
//    @RequestMapping("/error")
//    @ResponseBody
//    public String getErrorPath() {
//        return "<center><h1>Something went wrong</h1></center>";
//    }
//}
