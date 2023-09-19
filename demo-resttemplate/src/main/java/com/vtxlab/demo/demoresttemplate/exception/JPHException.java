package com.vtxlab.demo.demoresttemplate.exception;

import com.vtxlab.demo.demoresttemplate.infra.BusinessException;
import com.vtxlab.demo.demoresttemplate.infra.Code;

public class JPHException extends BusinessException {

  public JPHException(Code code) {
    super(code);
  }
}
