/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnLink extends GnObject {
  private long swigCPtr;

  protected GnLink(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnLink_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnLink obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnLink(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

	private IGnStatusEvents pEventHandler;
	private IGnStatusEventsProxyU eventHandlerProxy;

  public GnLink(GnDataObject gnDataObject, GnUser user, IGnStatusEvents pEventHandler) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnLink__SWIG_0(GnDataObject.getCPtr(gnDataObject), gnDataObject, GnUser.getCPtr(user), user, (eventHandlerProxy==null)?0:IGnStatusEventsProxyL.getCPtr(eventHandlerProxy), eventHandlerProxy);
}

  public GnLink(GnDataObject gnDataObject, GnUser user) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnLink__SWIG_1(GnDataObject.getCPtr(gnDataObject), gnDataObject, GnUser.getCPtr(user), user);
}

  public GnLink(GnListElement listElement, GnUser user, IGnStatusEvents pEventHandler) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnLink__SWIG_2(GnListElement.getCPtr(listElement), listElement, GnUser.getCPtr(user), user, (eventHandlerProxy==null)?0:IGnStatusEventsProxyL.getCPtr(eventHandlerProxy), eventHandlerProxy);
}

  public GnLink(GnListElement listElement, GnUser user) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnLink__SWIG_3(GnListElement.getCPtr(listElement), listElement, GnUser.getCPtr(user), user);
}

  public static String version() {
    return gnsdk_javaJNI.GnLink_version();
  }

  public static String buildDate() {
    return gnsdk_javaJNI.GnLink_buildDate();
  }

  public long count(GnLinkContentType contentType) throws com.gracenote.gnsdk.GnException {
    return gnsdk_javaJNI.GnLink_count(swigCPtr, this, contentType.swigValue());
  }

  public GnLinkOptions options() {
    return new GnLinkOptions(gnsdk_javaJNI.GnLink_options(swigCPtr, this), false);
  }

  public GnLinkContent coverArt(GnImageSize imageSize, GnImagePreference imagePreference, long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_coverArt__SWIG_0(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue(), item_ord), true);
  }

  public GnLinkContent coverArt(GnImageSize imageSize, GnImagePreference imagePreference) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_coverArt__SWIG_1(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue()), true);
  }

  public GnLinkContent genreArt(GnImageSize imageSize, GnImagePreference imagePreference, long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_genreArt__SWIG_0(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue(), item_ord), true);
  }

  public GnLinkContent genreArt(GnImageSize imageSize, GnImagePreference imagePreference) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_genreArt__SWIG_1(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue()), true);
  }

  public GnLinkContent image(GnImageSize imageSize, GnImagePreference imagePreference, long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_image__SWIG_0(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue(), item_ord), true);
  }

  public GnLinkContent image(GnImageSize imageSize, GnImagePreference imagePreference) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_image__SWIG_1(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue()), true);
  }

  public GnLinkContent artistImage(GnImageSize imageSize, GnImagePreference imagePreference, long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_artistImage__SWIG_0(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue(), item_ord), true);
  }

  public GnLinkContent artistImage(GnImageSize imageSize, GnImagePreference imagePreference) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_artistImage__SWIG_1(swigCPtr, this, imageSize.swigValue(), imagePreference.swigValue()), true);
  }

  public GnLinkContent review(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_review__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent review() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_review__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent biography(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_biography__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent biography() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_biography__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent artistNews(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_artistNews__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent artistNews() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_artistNews__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent lyricXML(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_lyricXML__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent lyricXML() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_lyricXML__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent lyricText(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_lyricText__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent lyricText() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_lyricText__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent commentsListener(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_commentsListener__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent commentsListener() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_commentsListener__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent commentsRelease(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_commentsRelease__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent commentsRelease() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_commentsRelease__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent news(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_news__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent news() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_news__SWIG_1(swigCPtr, this), true);
  }

  public GnLinkContent dspData(long item_ord) throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_dspData__SWIG_0(swigCPtr, this, item_ord), true);
  }

  public GnLinkContent dspData() throws com.gracenote.gnsdk.GnException {
    return new GnLinkContent(gnsdk_javaJNI.GnLink_dspData__SWIG_1(swigCPtr, this), true);
  }

  public IGnStatusEvents eventHandler() {
	return pEventHandler;
}

  public void setCancel(boolean bCancel) {
    gnsdk_javaJNI.GnLink_setCancel(swigCPtr, this, bCancel);
  }

  public boolean isCancelled() {
    return gnsdk_javaJNI.GnLink_isCancelled(swigCPtr, this);
  }

}