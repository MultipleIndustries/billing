package  com.multiple.kernel.exception;

import static org.junit.Assert.fail;

public class ExceptionLog {
	
	public static void println(String message, Exception ex)
	{
		System.out.println(message + " " + ex.getMessage());
		//ex.printStackTrace();
		//System.err.println("");
		//throw new ExceptionInInitializerError(ex);
	}
	
	public static void println(String message, int failMessageCode)
	{
		System.out.println(message + " " + failMessageCode);
	}

	public static void println(String message, String failMessage)
	{
		System.out.println(message + " " + failMessage);
	}
	
	public static void assertFail(String methodMetadata, int failMessageCode)
	{
		fail(methodMetadata + " " + failMessageCode);
	}
	
	public static void assertFail(String methodMetadata, String failMessage)
	{
		fail(methodMetadata + " " + failMessage);
	}
	
	public static void assertFail(String methodMetadata, Exception ex)
	{
		fail(methodMetadata + " " + ex.getMessage());
	}
	
	public static void assertFail(String methodMetadata, String failMessage, Exception ex)
	{
		fail(methodMetadata + " " + failMessage + " " + ex.getMessage());
	}
}
