package p3;

import java.util.Arrays;
import java.util.List;

public class UserService {

	public String getProject(String[] tech)
	{
		List<String> list = Arrays.asList(tech);
		if(list.contains("Java") && list.contains("Angular"))
			return "Java Full Stack Project";
		else if(list.contains("Python") && list.contains("R"))
			return "AI Project";
		else if(list.contains("Oracle"))
			return "DBA";
		else if(list.contains("Juniper"))
			return "Network Admin";
		return "No Project Assigned";
	}
	
}
