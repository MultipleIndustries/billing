package com.multiple.common.exception;

import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;

public class OverlapedSlabException extends BusinessException{
	
	public OverlapedSlabException() {
		super(CustomException.DISCOUNT_SLAB_OVERLAP.getCode());
	}

	public OverlapedSlabException(String errorCode){
		super(errorCode);
	}
	 
}
