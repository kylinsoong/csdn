package org.jboss.csdn.viewer;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args){
		
		List<String> ids = new ArrayList<String>();
		ids.add("12340101");
		
		PvAdderUtils.pvAddForCSDNBlogForSingleUserMultiPage("kylinsoong", ids, 1326, 10);
	}

	
}
