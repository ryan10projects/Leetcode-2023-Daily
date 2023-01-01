class Solution
{
  public:
	bool wordPattern(string pattern, string s)
	{
                //Using a HashMap for mapping each word to a character in pattern
		unordered_map<string, char> map;
		vector<string> array;
		string temp;
                //Converting the string of words into an vector array
		for (int i = 0; i < s.size(); i++)
		{
			if (s[i] != ' ')
			{
				temp += s[i];
			}
			else
			{
				array.push_back(temp);
				temp = "";
			}
			if (i == s.size() - 1)
				array.push_back(temp);
		}

		if (pattern.size() != array.size())
			return false;

		for (int i = 0; i < pattern.size(); i++)
		{
			if (map.count(array[i]))
			{
                                //comparing if the character in pattern is same as the value in the HashMap
				if (pattern[i] != map.at(array[i]))
				{
					return false;
				}
			}
			else
			{
				for (const auto &iter : map)
				{
					if (iter.second == pattern[i])
					{
						return false;
					}
				}
				map[array[i]] = pattern[i];
			}
		}
		return true;
	}
};
