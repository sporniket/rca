/**
 *
 */
package com.sporniket.libre.rca.resteasy ;

import static java.util.stream.Collectors.toMap ;
import static org.apache.commons.lang3.StringUtils.isNotBlank ;

import java.util.AbstractMap ;
import java.util.Map ;

import org.jboss.resteasy.core.Dispatcher ;
import org.jboss.resteasy.mock.MockHttpRequest ;
import org.jboss.resteasy.mock.MockHttpResponse ;

/**
 * Factory that build a rest call using a RestEasy dispatcher.
 *
 * @author spornda
 *
 */
public class RestCallFactoryRestEasy {

    public static final RestCall build(Dispatcher dispatcher) {
        return req -> {
            try {
                MockHttpRequest request = RestRequestMethod.POST == req.getMethod() || isNotBlank(req.getBody()) //
                        ? MockHttpRequest.post(req.getUrl()).content(req.getBody().getBytes(req.getBodyEncoding()))
                        : MockHttpRequest.get(req.getUrl()) ;
                req.getHeaders().entrySet().stream()//
                        .forEach(h -> request.header(h.getKey(), (String) h.getValue())) ;

                MockHttpResponse response = new MockHttpResponse() ;

                dispatcher.invoke(request, response) ;

                return new RestResponse_Builder()//
                        .withStatus(response.getStatus())//
                        .withHeaders(response.getOutputHeaders().entrySet()//
                                .stream()//
                                .map(e -> new AbstractMap.SimpleEntry<String, Object>(//
                                        e.getKey(), //
                                        e.getValue().isEmpty() //
                                                ? null
                                                : e.getValue().size() == 1 //
                                                        ? e.getValue().get(0)
                                                        : e.getValue()))//
                                .collect(toMap(Map.Entry<String, Object>::getKey, Map.Entry<String, Object>::getValue))) //
                        .withBody(response.getContentAsString()) //
                        .done() ;
            } catch (Exception e) {
                throw new RestCallException(e.getMessage(), e) ;
            }
        } ;
    }
}
