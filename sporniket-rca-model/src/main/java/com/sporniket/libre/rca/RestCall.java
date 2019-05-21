/**
 *
 */
package com.sporniket.libre.rca ;

/**
 * Modèle d'un appel rest.
 *
 * @author spornda
 *
 */
public interface RestCall {

    RestResponse perform(RestRequest request) throws RestCallException ;
}
