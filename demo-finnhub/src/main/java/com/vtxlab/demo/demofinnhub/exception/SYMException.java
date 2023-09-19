package com.vtxlab.demo.demofinnhub.exception;

import com.vtxlab.demo.demofinnhub.infra.BusinessException;
import com.vtxlab.demo.demofinnhub.infra.Code;

public class SYMException extends BusinessException {

  public SYMException(Code code) {
    super(code);
  }
}
