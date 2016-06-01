/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnDsp extends GnObject {
  private long swigCPtr;

  protected GnDsp(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnDsp_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnDsp obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnDsp(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

  public GnDsp(GnUser user, GnDspFeatureType featureType, long audioSampleRate, long audioSampleSize, long audioChannels) throws com.gracenote.gnsdk.GnException {
    this(gnsdk_javaJNI.new_GnDsp(GnUser.getCPtr(user), user, featureType.swigValue(), audioSampleRate, audioSampleSize, audioChannels), true);
  }

  public static String version() {
    return gnsdk_javaJNI.GnDsp_version();
  }

  public static String buildDate() {
    return gnsdk_javaJNI.GnDsp_buildDate();
  }

  public boolean featureAudioWrite(byte[] audioData, long audioDataBytes) throws com.gracenote.gnsdk.GnException {
    return gnsdk_javaJNI.GnDsp_featureAudioWrite(swigCPtr, this, audioData, audioDataBytes);
  }

  public void featureEndOfAudioWrite() throws com.gracenote.gnsdk.GnException {
    gnsdk_javaJNI.GnDsp_featureEndOfAudioWrite(swigCPtr, this);
  }

  public GnDspFeature featureRetrieve() throws com.gracenote.gnsdk.GnException {
    return new GnDspFeature(gnsdk_javaJNI.GnDsp_featureRetrieve(swigCPtr, this), true);
  }

}