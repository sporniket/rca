/**
 *
 */
package com.sporniket.libre.rca ;

/**
 * Exceptions levées par un appel rest.
 *
 * @author spornda
 *
 */
public class RestCallException extends RuntimeException {

    private static final long serialVersionUID = 2110032978115662245L ;

    public RestCallException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public RestCallException(String arg0) {
        super(arg0) ;
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     */
    public RestCallException(Throwable arg0) {
        super(arg0) ;
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     */
    public RestCallException(String arg0, Throwable arg1) {
        super(arg0, arg1) ;
        // TODO Auto-generated constructor stub
    }

    /**
     * @param arg0
     * @param arg1
     * @param arg2
     * @param arg3
     */
    public RestCallException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
        super(arg0, arg1, arg2, arg3) ;
        // TODO Auto-generated constructor stub
    }

}
