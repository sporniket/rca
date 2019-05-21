/**
 *
 */
package com.sporniket.libre.rca ;

import java.nio.charset.Charset ;
import java.util.Map ;

/**
 * Abstraction d'un appel rest.
 *
 * @author spornda
 *
 */
class RestRequestRaw {

    String body ;

    Charset bodyEncoding ;

    Map<String, Object> headers ;

    RestRequestMethod method ;

    String url ;
}
