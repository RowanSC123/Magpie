/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie2
{
	/**
	 * Get a default greeting 	
	 * @return a greeting
	 */
	public String getGreeting()
	{
		return "Hello, let's talk.";
	}
	
	/**
	 * Gives a response to a user statement
	 * 
	 * @param statement
	 *            the user statement
	 * @return a response based on the rules given
	 */
	public String getResponse(String statement)
	{
		statement = " " + statement + " "; /*adds spaces to the ends of the string.
		This works to prevent accidentally responding to words within words,
		such as with "meow" in "homeowner". Will not affect the trim() method.
		The bad news is that we have to specify plurals individually now*/

		//the following if-else statements are to format responses with correct pronouns
		String response = "";
		String prefix = "";
		String plural = "";
		if (statement.indexOf(" Mr. ") >= 0){ //statement.contains(" Mr. "); could have worked?
			prefix = "He";
			plural = "s";
		}
		else if (statement.indexOf(" Mrs. ") >= 0
				|| statement.indexOf(" Ms. ") >= 0){
			prefix = "She";
			plural = "s";
		}
		else{
			prefix = "They";
		}

		//determines response from user keywords in priority order
		if (statement.indexOf(" no ") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf(" mother ") >= 0
				|| statement.indexOf(" father ") >= 0
				|| statement.indexOf(" sister ") >= 0
				|| statement.indexOf(" brother ") >= 0)
		{
			response = "Tell me more about your family.";
		}
		else if (statement.indexOf(" dog ") >= 0
				|| statement.indexOf(" dogs ") >= 0
				|| statement.indexOf(" cat ") >= 0
				|| statement.indexOf(" cats ") >= 0)
		{
			response = "Tell me more about your pets.";
		}
		else if (statement.indexOf(" Mr. ") >= 0
				|| statement.indexOf(" Mrs. ") >= 0
				|| statement.indexOf(" Ms. ") >= 0
				|| statement.indexOf(" Dr. ") >= 0){
			response = prefix + " sound" + plural + " like a good teacher."; //not the most elegant solution
		}
		else if (statement.indexOf(" game ") >= 0
		        || statement.indexOf(" games ") >= 0){
			response = "What games do you like to play?";
		}
		else if (statement.indexOf(" sorry ") >= 0){
			response = "I accept your apology.";
		}
		else if (statement.trim().equals("")){
			response = "Say something, please.";
		}
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
		String response = "";
		
		if (whichResponse == 0)
		{
			response = "Interesting, tell me more.";
		}
		else if (whichResponse == 1)
		{
			response = "Hmmm.";
		}
		else if (whichResponse == 2)
		{
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
		else if (whichResponse == 4)
		{
			response = "Uh-huh.";
		}
		else if (whichResponse == 5)
		{
			response = "Sure.";
		}

		return response;
	}
}
