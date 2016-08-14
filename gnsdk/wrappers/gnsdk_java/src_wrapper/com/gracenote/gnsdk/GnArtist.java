/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnArtist extends GnDataObject {
  private long swigCPtr;

  protected GnArtist(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnArtist_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnArtist obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnArtist(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public static String gnType() {
    return gnsdk_javaJNI.GnArtist_gnType();
  }

  public static GnArtist from(GnDataObject obj) throws com.gracenote.gnsdk.GnException {
    return new GnArtist(gnsdk_javaJNI.GnArtist_from(GnDataObject.getCPtr(obj), obj), true);
  }

  public GnName name() {
    return new GnName(gnsdk_javaJNI.GnArtist_name(swigCPtr, this), true);
  }

  public GnContributor contributor() {
    return new GnContributor(gnsdk_javaJNI.GnArtist_contributor(swigCPtr, this), true);
  }

}