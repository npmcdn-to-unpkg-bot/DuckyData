/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnVideoCreditIterator {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected GnVideoCreditIterator(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnVideoCreditIterator obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnVideoCreditIterator(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public GnVideoCredit __ref__() throws com.gracenote.gnsdk.GnException {
    return new GnVideoCredit(gnsdk_javaJNI.GnVideoCreditIterator___ref__(swigCPtr, this), false);
  }

  public GnVideoCredit next() throws com.gracenote.gnsdk.GnException {
    return new GnVideoCredit(gnsdk_javaJNI.GnVideoCreditIterator_next(swigCPtr, this), true);
  }

  public boolean hasNext() {
    return gnsdk_javaJNI.GnVideoCreditIterator_hasNext(swigCPtr, this);
  }

  public long distance(GnVideoCreditIterator itr) {
    return gnsdk_javaJNI.GnVideoCreditIterator_distance(swigCPtr, this, GnVideoCreditIterator.getCPtr(itr), itr);
  }

  public GnVideoCreditIterator(GnVideoCreditProvider provider, long pos) {
    this(gnsdk_javaJNI.new_GnVideoCreditIterator(GnVideoCreditProvider.getCPtr(provider), provider, pos), true);
  }

}
