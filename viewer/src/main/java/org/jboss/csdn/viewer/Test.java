package org.jboss.csdn.viewer;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args){
		
		List<String> ids = new ArrayList<String>();
		ids.add("12684431");
		
		PvAdderUtils.pvAddForCSDNBlogForSingleUserMultiPage("kylinsoong", ids, 841, 10);
	}

	
}
