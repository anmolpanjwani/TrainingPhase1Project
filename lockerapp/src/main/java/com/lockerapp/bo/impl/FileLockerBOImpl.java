package com.lockerapp.bo.impl;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import com.lockerapp.bo.FileLockerBO;
import com.lockerapp.exception.BusinessException;
import com.lockerapp.model.FileLocker;

public class FileLockerBOImpl implements FileLockerBO{
private static Map<String, FileLocker> filemap = new LinkedHashMap<>();

	@Override
	public void getAllCurrentFiles() throws BusinessException{
		Map<String, FileLocker> ts = new TreeMap<String, FileLocker>(filemap);
		try {
			if(!filemap.isEmpty()) {
				for (Map.Entry<String, FileLocker> entry : ts.entrySet()) {
					String name = entry.getKey();
					System.out.println(name);
						}
				}
			else {
				throw new BusinessException("The directory is empty. Why don't you try to add files?");
			}
		}
		catch (BusinessException e) {
		}
			
	}

	@Override
	public FileLocker addFile(FileLocker fileobj) throws BusinessException {
		//Write validations
//		if(fileobj.getFilename()!=null) {
			filemap.put(fileobj.getFilename(), fileobj);
			return fileobj;
//		}
//		else {
//			
//		}
		}


	@Override
	public void deleteFileByName(String filename) throws BusinessException{
		try {
			if(filemap.containsKey(filename)) {
				filemap.remove(filename);
				System.out.println("File with name "+filename+" is deleted Successfully.");
			}
		} catch (BusinessException e) {
				throw new BusinessException("File with this name doesn't exist.");
		}
			
		
	}

	@Override
	public FileLocker searchFileByName(String filename) throws BusinessException{
		
		if(filemap.containsKey(filename)){
			FileLocker fileobj = filemap.get(filename);
			return fileobj;
//		}
//		else {
//			throw new BusinessException("Oops. File with name " +filename+ " not found.");
//	}

}
		return null;
}
}