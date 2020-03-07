/**
 * 
 */
package personal.billson.codility.lession001;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author billson
 *
 */
public class Solution {

	private static boolean IS_DEBUG = Boolean.FALSE;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		IS_DEBUG = Boolean.TRUE;
		Solution sol = new Solution();
		
		int N = 0;
		/*
		N = 1041;
		Logger.getGlobal().log( Level.INFO, "Passing|"+N );
		Logger.getGlobal().log( Level.INFO, "Max Matched|"+sol.solution( N ) );
		
		N = 10411041;
		Logger.getGlobal().log( Level.INFO, "Passing|"+N );
		Logger.getGlobal().log( Level.INFO, "Max Matched|"+sol.solution( N ) );
		*/
		N = 6;
		Logger.getGlobal().log( Level.INFO, "Passing|"+N );
		Logger.getGlobal().log( Level.INFO, "Max Matched|"+sol.solution( N ) );

		N = 32;
		Logger.getGlobal().log( Level.INFO, "Passing|"+N );
		Logger.getGlobal().log( Level.INFO, "Max Matched|"+sol.solution( N ) );
	}
	
	char CHR_TARGET = '0';
	
	public int solution (int N)
	{
		
		/*
		if ( N<0 && N>2147483647 )
			return 0;
		*/
		 
		String strBinary = Integer.toBinaryString( N );
		int intBinaryLength = strBinary.length();


		if ( IS_DEBUG )
			Logger.getGlobal().log( Level.INFO, "strBinary|"+strBinary );
		
		int intMatchedMax = 0, intMatchedCurrent = 0;
		
		char chrCurrent = ' ', chrCurrentCheck = ' ';
		
		for ( int intBinaryLoop = 0; intBinaryLoop<intBinaryLength; intBinaryLoop++ )
		{
			
			chrCurrent = strBinary.charAt( intBinaryLoop );

			if ( chrCurrent==CHR_TARGET && intBinaryLoop < intBinaryLength - 1 )
			{
				intMatchedCurrent = 1;
			}
			else
			{	
				continue;
			}
			
			for ( int intBinaryLoopCheck = intBinaryLoop+1; intBinaryLoopCheck<intBinaryLength; intBinaryLoopCheck++ )
			{
				
				chrCurrentCheck = strBinary.charAt( intBinaryLoopCheck );
				if ( chrCurrent!=chrCurrentCheck )
				{
					intBinaryLoop = intBinaryLoopCheck;
					break;
				}
				else
				{
					intMatchedCurrent++;
					
					if ( intBinaryLoopCheck == ( intBinaryLength - 1 ) )
					{
						intBinaryLoop = intBinaryLoopCheck;
						
						intMatchedCurrent = 0;
						
					}
					
//					Logger.getGlobal().log( Level.INFO, "Matched|"+intMatchedCurrent );
					
				}
			}
			
			if ( IS_DEBUG )
				Logger.getGlobal().log( Level.INFO, "intMatchedCurrent|"+intMatchedCurrent );
			
			if ( intMatchedMax==0 )
				intMatchedMax = intMatchedCurrent;
			else if ( intMatchedCurrent > intMatchedMax )
			{
				intMatchedMax = intMatchedCurrent;
			}
		}
		
		return intMatchedMax;
	}
	
}
