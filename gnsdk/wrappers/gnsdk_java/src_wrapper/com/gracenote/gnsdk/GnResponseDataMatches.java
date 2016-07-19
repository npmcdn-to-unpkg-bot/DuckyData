/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnResponseDataMatches extends GnDataObject {
  private long swigCPtr;

  protected GnResponseDataMatches(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnResponseDataMatches_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnResponseDataMatches obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnResponseDataMatches(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public long resultCount() {
    return gnsdk_javaJNI.GnResponseDataMatches_resultCount(swigCPtr, this);
  }

  public long rangeStart() {
    return gnsdk_javaJNI.GnResponseDataMatches_rangeStart(swigCPtr, this);
  }

  public long rangeEnd() {
    return gnsdk_javaJNI.GnResponseDataMatches_rangeEnd(swigCPtr, this);
  }

  public long rangeTotal() {
    return gnsdk_javaJNI.GnResponseDataMatches_rangeTotal(swigCPtr, this);
  }

  public boolean needsDecision() {
    return gnsdk_javaJNI.GnResponseDataMatches_needsDecision(swigCPtr, this);
  }

  public GnDataMatchIterable dataMatches() {
    return new GnDataMatchIterable(gnsdk_javaJNI.GnResponseDataMatches_dataMatches(swigCPtr, this), true);
  }

}
