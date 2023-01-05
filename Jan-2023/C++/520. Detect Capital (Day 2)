//520. Detect Capital

class Solution
{
  public:
	bool detectCapitalUse(string word)
	{
		int count = 0;
		for (int i = 0; i < word.size(); i++)
		{
			//inbuilt function to check for uppercase
			if (isupper(word[i]))
			{
				count++;
			}
		}
		//checking all 3 conditions
		return count == 0 || count == word.size() || count == 1 && isupper(word[0]);
	}
};
