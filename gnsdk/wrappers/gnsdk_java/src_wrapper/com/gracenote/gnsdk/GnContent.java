/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnContent extends GnDataObject {
  private long swigCPtr;

  protected GnContent(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnContent_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnContent obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnContent(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public String Id() {
    return gnsdk_javaJNI.GnContent_Id(swigCPtr, this);
  }

  public GnContentType contentType() {
    return GnContentType.swigToEnum(gnsdk_javaJNI.GnContent_contentType(swigCPtr, this));
  }

  public String mimeType() {
    return gnsdk_javaJNI.GnContent_mimeType(swigCPtr, this);
  }

  public GnAsset asset(GnImageSize imageSize) {
    return new GnAsset(gnsdk_javaJNI.GnContent_asset(swigCPtr, this, imageSize.swigValue()), true);
  }

  public GnAssetIterable assets() {
    return new GnAssetIterable(gnsdk_javaJNI.GnContent_assets(swigCPtr, this), true);
  }

}
