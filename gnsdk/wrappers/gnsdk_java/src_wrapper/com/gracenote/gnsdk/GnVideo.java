/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 2.0.12
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.gracenote.gnsdk;

public class GnVideo extends GnObject {
  private long swigCPtr;

  protected GnVideo(long cPtr, boolean cMemoryOwn) {
    super(gnsdk_javaJNI.GnVideo_SWIGUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }

  protected static long getCPtr(GnVideo obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        gnsdk_javaJNI.delete_GnVideo(swigCPtr);
      }
      swigCPtr = 0;
    }
    super.delete();
  }

	private IGnStatusEvents pEventHandler;
	private IGnStatusEventsProxyU eventHandlerProxy;
	private GnLocale locale;

    private long getCancellerCPtrFromCancellable(IGnCancellable cancellable) {
    	if ( cancellable instanceof IGnCancellableProxy ){
    		IGnCancellableProxy canceller = (IGnCancellableProxy)cancellable;
    		return IGnCancellableProxy.getCPtr(canceller);
    	}
    	return 0;
    }

  public GnVideo(GnUser user, IGnStatusEvents pEventHandler) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	if ( pEventHandler != null )
	{
		eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	}
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	this.locale = locale; 				// <REFERENCE_NAME_CHECK><TYPE>GnLocale</TYPE><NAME>locale</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnVideo__SWIG_0(GnUser.getCPtr(user), user, (eventHandlerProxy==null)?0:IGnStatusEventsProxyL.getCPtr(eventHandlerProxy), eventHandlerProxy);
}

  public GnVideo(GnUser user) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	if ( pEventHandler != null )
	{
		eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	}
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	this.locale = locale; 				// <REFERENCE_NAME_CHECK><TYPE>GnLocale</TYPE><NAME>locale</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnVideo__SWIG_1(GnUser.getCPtr(user), user);
}

  public GnVideo(GnUser user, GnLocale locale, IGnStatusEvents pEventHandler) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	if ( pEventHandler != null )
	{
		eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	}
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	this.locale = locale; 				// <REFERENCE_NAME_CHECK><TYPE>GnLocale</TYPE><NAME>locale</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnVideo__SWIG_2(GnUser.getCPtr(user), user, GnLocale.getCPtr(locale), locale, (eventHandlerProxy==null)?0:IGnStatusEventsProxyL.getCPtr(eventHandlerProxy), eventHandlerProxy);
}

  public GnVideo(GnUser user, GnLocale locale) throws com.gracenote.gnsdk.GnException {
	this(0, true);
	
	if ( pEventHandler != null )
	{
		eventHandlerProxy = new IGnStatusEventsProxyU(pEventHandler);
	}
	this.pEventHandler=pEventHandler;	// <REFERENCE_NAME_CHECK><TYPE>IGnStatusEvents</TYPE><NAME>pEventHandler</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	this.locale = locale; 				// <REFERENCE_NAME_CHECK><TYPE>GnLocale</TYPE><NAME>locale</NAME></REFERENCE_NAME_CHECK> leave for scripted verification of names
	
	swigCPtr = gnsdk_javaJNI.new_GnVideo__SWIG_3(GnUser.getCPtr(user), user, GnLocale.getCPtr(locale), locale);
}

  public static String version() {
    return gnsdk_javaJNI.GnVideo_version();
  }

  public static String buildDate() {
    return gnsdk_javaJNI.GnVideo_buildDate();
  }

  public GnVideoOptions options() {
    return new GnVideoOptions(gnsdk_javaJNI.GnVideo_options(swigCPtr, this), false);
  }

  public GnResponseVideoProduct findProducts(String videoTOC, GnVideoTOCFlag TOCFlag) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_0(swigCPtr, this, videoTOC, TOCFlag.swigValue()), true);
  }

  public GnResponseVideoProduct findProducts(GnVideoProduct videoProduct) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_1(swigCPtr, this, GnVideoProduct.getCPtr(videoProduct), videoProduct), true);
  }

  public GnResponseVideoProduct findProducts(GnVideoWork videoWork) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_2(swigCPtr, this, GnVideoWork.getCPtr(videoWork), videoWork), true);
  }

  public GnResponseVideoProduct findProducts(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_3(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseVideoProduct findProducts(String textInput, GnVideoSearchField searchField, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_4(swigCPtr, this, textInput, searchField.swigValue(), searchType.swigValue()), true);
  }

  public GnResponseVideoProduct findProducts(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoProduct(gnsdk_javaJNI.GnVideo_findProducts__SWIG_5(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseVideoWork findWorks(GnVideoProduct videoProduct) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_0(swigCPtr, this, GnVideoProduct.getCPtr(videoProduct), videoProduct), true);
  }

  public GnResponseVideoWork findWorks(GnVideoWork videoWork) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_1(swigCPtr, this, GnVideoWork.getCPtr(videoWork), videoWork), true);
  }

  public GnResponseVideoWork findWorks(GnContributor contributor) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_2(swigCPtr, this, GnContributor.getCPtr(contributor), contributor), true);
  }

  public GnResponseVideoWork findWorks(GnVideoSeason videoSeason) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_3(swigCPtr, this, GnVideoSeason.getCPtr(videoSeason), videoSeason), true);
  }

  public GnResponseVideoWork findWorks(GnVideoSeries videoSeries) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_4(swigCPtr, this, GnVideoSeries.getCPtr(videoSeries), videoSeries), true);
  }

  public GnResponseVideoWork findWorks(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_5(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseVideoWork findWorks(String textInput, GnVideoSearchField searchField, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_6(swigCPtr, this, textInput, searchField.swigValue(), searchType.swigValue()), true);
  }

  public GnResponseVideoWork findWorks(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoWork(gnsdk_javaJNI.GnVideo_findWorks__SWIG_7(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseVideoSeasons findSeasons(GnVideoWork videoWork) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_0(swigCPtr, this, GnVideoWork.getCPtr(videoWork), videoWork), true);
  }

  public GnResponseVideoSeasons findSeasons(GnContributor contributor) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_1(swigCPtr, this, GnContributor.getCPtr(contributor), contributor), true);
  }

  public GnResponseVideoSeasons findSeasons(GnVideoSeason videoSeason) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_2(swigCPtr, this, GnVideoSeason.getCPtr(videoSeason), videoSeason), true);
  }

  public GnResponseVideoSeasons findSeasons(GnVideoSeries videoSeries) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_3(swigCPtr, this, GnVideoSeries.getCPtr(videoSeries), videoSeries), true);
  }

  public GnResponseVideoSeasons findSeasons(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_4(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseVideoSeasons findSeasons(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeasons(gnsdk_javaJNI.GnVideo_findSeasons__SWIG_5(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseVideoSeries findSeries(GnVideoWork videoWork) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_0(swigCPtr, this, GnVideoWork.getCPtr(videoWork), videoWork), true);
  }

  public GnResponseVideoSeries findSeries(GnContributor contributor) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_1(swigCPtr, this, GnContributor.getCPtr(contributor), contributor), true);
  }

  public GnResponseVideoSeries findSeries(GnVideoSeason videoSeason) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_2(swigCPtr, this, GnVideoSeason.getCPtr(videoSeason), videoSeason), true);
  }

  public GnResponseVideoSeries findSeries(GnVideoSeries videoSeries) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_3(swigCPtr, this, GnVideoSeries.getCPtr(videoSeries), videoSeries), true);
  }

  public GnResponseVideoSeries findSeries(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_4(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseVideoSeries findSeries(String textInput, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_5(swigCPtr, this, textInput, searchType.swigValue()), true);
  }

  public GnResponseVideoSeries findSeries(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSeries(gnsdk_javaJNI.GnVideo_findSeries__SWIG_6(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseContributors findContributors(GnVideoWork videoWork) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_0(swigCPtr, this, GnVideoWork.getCPtr(videoWork), videoWork), true);
  }

  public GnResponseContributors findContributors(GnContributor contributor) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_1(swigCPtr, this, GnContributor.getCPtr(contributor), contributor), true);
  }

  public GnResponseContributors findContributors(GnVideoSeason videoSeason) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_2(swigCPtr, this, GnVideoSeason.getCPtr(videoSeason), videoSeason), true);
  }

  public GnResponseContributors findContributors(GnVideoSeries videoSeries) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_3(swigCPtr, this, GnVideoSeries.getCPtr(videoSeries), videoSeries), true);
  }

  public GnResponseContributors findContributors(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_4(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseContributors findContributors(String textInput, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_5(swigCPtr, this, textInput, searchType.swigValue()), true);
  }

  public GnResponseContributors findContributors(String searchText, GnVideoSearchField searchField, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_6(swigCPtr, this, searchText, searchField.swigValue(), searchType.swigValue()), true);
  }

  public GnResponseContributors findContributors(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseContributors(gnsdk_javaJNI.GnVideo_findContributors__SWIG_7(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseVideoObjects findObjects(GnDataObject gnObj) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoObjects(gnsdk_javaJNI.GnVideo_findObjects__SWIG_0(swigCPtr, this, GnDataObject.getCPtr(gnObj), gnObj), true);
  }

  public GnResponseVideoObjects findObjects(String externalId, GnVideoExternalIdType externalIdType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoObjects(gnsdk_javaJNI.GnVideo_findObjects__SWIG_1(swigCPtr, this, externalId, externalIdType.swigValue()), true);
  }

  public GnResponseVideoSuggestions findSuggestions(String searchText, GnVideoSearchField searchField, GnVideoSearchType searchType) throws com.gracenote.gnsdk.GnException {
    return new GnResponseVideoSuggestions(gnsdk_javaJNI.GnVideo_findSuggestions(swigCPtr, this, searchText, searchField.swigValue(), searchType.swigValue()), true);
  }

  public IGnStatusEvents eventHandler() {
	return pEventHandler;
}

  public void setCancel(boolean bCancel) {
    gnsdk_javaJNI.GnVideo_setCancel(swigCPtr, this, bCancel);
  }

  public boolean isCancelled() {
    return gnsdk_javaJNI.GnVideo_isCancelled(swigCPtr, this);
  }

}
