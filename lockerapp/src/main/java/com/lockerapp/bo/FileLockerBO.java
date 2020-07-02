package com.lockerapp.bo;

import com.lockerapp.exception.BusinessException;
import com.lockerapp.model.FileLocker;

public interface FileLockerBO {
	public void getAllCurrentFiles() throws BusinessException;
	public FileLocker addFile(FileLocker fileobj) throws BusinessException;
	public void deleteFileByName(String filename) throws BusinessException;
	public FileLocker searchFileByName(String filename) throws BusinessException;
}