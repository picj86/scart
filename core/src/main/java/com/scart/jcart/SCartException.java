/**
 * 
 */
package com.scart.jcart;

/**
 * @author Siva
 *
 */
public class SCartException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public SCartException()
	{
		super();
	}

	public SCartException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SCartException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public SCartException(String message)
	{
		super(message);
	}

	public SCartException(Throwable cause)
	{
		super(cause);
	}
	
}
