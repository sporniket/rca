/**
 *
 */
package com.sporniket.libre.rca ;

import java.util.Map ;

/**
 * Abstraction d'une réponse d'un appel rest.
 *
 * @author spornda
 *
 */
class RestResponseRaw {

    int status ;

    Map<String, Object> headers ;

    String body ;
}
