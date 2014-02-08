package org.jboss.csdn.viewer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	
	
	private static final int target = 2000;  
    private static final int errorCount = 10;

	public static void main(String[] args) throws IOException {
		
		String fileName = "ids";
		if(args.length > 0) {
			fileName = args[0];
		}

		final List<String> ids = getIdList(fileName);
		
		System.out.println("Blog ID list: " + ids);
		
		PvAdderUtils.pvAddForCSDNBlogForSingleUserMultiPage("kylinsoong", ids, target, errorCount);
		
		System.out.println("PV Viewer exit");
	}
	
	private static List<String> getIdList(String fileName) throws IOException {
		InputStream fis = null;
		BufferedReader br = null;
		String line;
		List<String> ids = new ArrayList<String>();

		try {
			fis = new FileInputStream(fileName);
			br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
			while ((line = br.readLine()) != null) {
				
				String[] array = line.replace(",", "").replace(";", "").split(" ");
				List<String> idList = Arrays.asList(array);
				ids.addAll(idList);
			}
			return ids;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (null != br) {
					br.close();
					br = null;
				}
				if (null != fis) {
					fis.close();
					fis = null;
				}
			} catch (IOException e) {
				throw e;
			}
		}
	}

}
