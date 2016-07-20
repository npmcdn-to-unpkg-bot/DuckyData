﻿/*
   @author qinxue.pan E-mail: xue@acrcloud.com
   @version 1.0.1
   @create 2015.10.01 
 
Copyright 2015 ACRCloud Recognizer v1.0.0

This module can recognize ACRCloud by most of audio/video file. 
        Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
        Video: mp4, mkv, wmv, flv, ts, avi ...
  
 */

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.InteropServices;

using System.Diagnostics;
using System.IO;

using System.Web;
using System.Security.Cryptography;
using System.Net;
using DuckyData1._0._0Alpha.Controllers;
using System.Drawing;
using DuckyData1._0._0Alpha.ViewModels;
using DuckyData1._0._0Alpha.Models;

namespace ACRCloud
{
    

    class ACRCloudExtrTool
    {
        public ACRCloudExtrTool()
        {
            acr_init();
        }

        /**
          *
          *  create "ACRCloud Fingerprint" by wav audio buffer(RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 8000 Hz) 
          *
          *  @param pcmBuffer query audio buffer
          *  @param pcmBufferLen the length of wavAudioBuffer
          *  @param isDB   If it is True, it will create db frigerprint; 
          *  
          *  @return result "ACRCloud Fingerprint"
          *
          **/
        public byte[] CreateFingerprint(byte[] pcmBuffer, int pcmBufferLen, bool isDB)
        {
            byte[] fpBuffer = null;
            if (pcmBuffer == null || pcmBufferLen <= 0)
            {
                return fpBuffer;
            }
            if (pcmBufferLen > pcmBuffer.Length)
            {
                pcmBufferLen = pcmBuffer.Length;
            }
            byte tIsDB = (isDB) ? (byte)1 : (byte)0;
            IntPtr pFpBuffer = IntPtr.Zero;
            int fpBufferLen = create_fingerprint(pcmBuffer, pcmBufferLen, tIsDB, ref pFpBuffer);
            if (fpBufferLen <= 0)
            {
                return fpBuffer;
            }

            fpBuffer = new byte[fpBufferLen];
            Marshal.Copy(pFpBuffer, fpBuffer, 0, fpBufferLen);
            acr_free(pFpBuffer);

            return fpBuffer;
        }

        /**
          *
          *  create "ACRCloud Fingerprint" by file path of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param filePath query file path
          *  @param startTimeSeconds skip (startSeconds) seconds from from the beginning of (filePath)
          *  @param audioLenSeconds Length of audio data you need. if you create recogize frigerprint, default is 12 seconds, if you create db frigerprint, it is not usefully; 
          *  @param isDB   If it is True, it will create db frigerprint; 
          *  
          *  @return result "ACRCloud Fingerprint"
          *
          **/
        public byte[] CreateFingerprintByFile(string filePath, int startTimeSeconds, int audioLenSeconds, bool isDB)
        {
            byte[] fpBuffer = null;

            byte tIsDB = (isDB) ? (byte)1 : (byte)0;
            IntPtr pFpBuffer = IntPtr.Zero;
            int fpBufferLen = create_fingerprint_by_file(filePath, startTimeSeconds, audioLenSeconds, tIsDB, ref pFpBuffer);
            switch (fpBufferLen)
            {
                case -1:
                    throw new Exception(filePath + " is not readable!");
                case -2:
                    throw new Exception(filePath + " can not be decoded audio data!");
            }
            if (fpBufferLen == 0)
            {
                return fpBuffer;
            }

            fpBuffer = new byte[fpBufferLen];
            Marshal.Copy(pFpBuffer, fpBuffer, 0, fpBufferLen);
            acr_free(pFpBuffer);

            return fpBuffer;
        }

        /**
          *
          *  create "ACRCloud Fingerprint" by file buffer of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param fileBuffer data buffer of input file
          *  @param fileBufferLen  length of fileBuffer
          *  @param startTimeSeconds skip (startSeconds) seconds from from the beginning of (filePath)
          *  @param audioLenSeconds Length of audio data you need. if you create recogize frigerprint, default is 12 seconds, if you create db frigerprint, it is not usefully; 
          *  @param isDB   If it is True, it will create db frigerprint; 
          *  
          *  @return result "ACRCloud Fingerprint"
          *
          **/
        public byte[] CreateFingerprintByFileBuffer(byte[] fileBuffer, int fileBufferLen, int startTimeSeconds, int audioLenSeconds, bool isDB)
        {
            byte[] fpBuffer = null;
            if (fileBufferLen > fileBuffer.Length)
            {
                fileBufferLen = fileBuffer.Length;
            }

            byte tIsDB = (isDB) ? (byte)1 : (byte)0;
            IntPtr pFpBuffer = IntPtr.Zero;
            int fpBufferLen = create_fingerprint_by_filebuffer(fileBuffer, fileBufferLen, startTimeSeconds, audioLenSeconds, tIsDB, ref pFpBuffer);
            switch (fpBufferLen)
            {
                case -1:
                    throw new Exception("fileBuffer is not audio/video data!");
                case -2:
                    throw new Exception("fileBuffer can not be decoded audio data!");
            }
            if (fpBufferLen == 0)
            {
                return fpBuffer;
            }

            fpBuffer = new byte[fpBufferLen];
            Marshal.Copy(pFpBuffer, fpBuffer, 0, fpBufferLen);
            acr_free(pFpBuffer);
            return fpBuffer;
        }

        /**
          *
          *  decode audio from file path of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param filePath query file path
          *  @param startTimeSeconds skip (startSeconds) seconds from from the beginning of (filePath)
          *  @param audioLenSeconds Length of audio data you need, if it is 0, will decode all the audio;  
          *  
          *  @return result audio data(formatter:RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 8000 Hz)
          *
          **/
        public byte[] DecodeAudioByFile(string filePath, int startTimeSeconds, int audioLenSeconds)
        {
            byte[] audioBuffer = null;

            IntPtr pAudioBuffer = IntPtr.Zero;
            int fpBufferLen = decode_audio_by_file(filePath, startTimeSeconds, audioLenSeconds, ref pAudioBuffer);
            switch (fpBufferLen)
            {
                case -1:
                    throw new Exception(filePath + " is not readable!");
                case -2:
                    throw new Exception(filePath + " can not be decoded audio data!");
            }
            if (fpBufferLen == 0)
            {
                return audioBuffer;
            }

            audioBuffer = new byte[fpBufferLen];
            Marshal.Copy(pAudioBuffer, audioBuffer, 0, fpBufferLen);
            acr_free(pAudioBuffer);

            return audioBuffer;
        }

        /**
          *
          *  decode audio from file buffer of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param fileBuffer data buffer of input file
          *  @param fileBufferLen  length of fileBuffer
          *  @param startTimeSeconds skip (startSeconds) seconds from from the beginning of (filePath)
          *  @param audioLenSeconds Length of audio data you need, if it is 0, will decode all the audio;  
          *  
          *  @return result audio data(formatter:RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 8000 Hz)
          *
          **/
        public byte[] DecodeAudioByFileBuffer(byte[] fileBuffer, int fileBufferLen, int startTimeSeconds, int audioLenSeconds)
        {
            byte[] audioBuffer = null;

            if (fileBufferLen > fileBuffer.Length)
            {
                fileBufferLen = fileBuffer.Length;
            }
            IntPtr pAudioBuffer = IntPtr.Zero;
            int fpBufferLen = decode_audio_by_filebuffer(fileBuffer, fileBufferLen, startTimeSeconds, audioLenSeconds, ref pAudioBuffer);
            switch (fpBufferLen)
            {
                case -1:
                    throw new Exception("fileBuffer is not audio/video data!");
                case -2:
                    throw new Exception("fileBuffer can not be decoded audio data!");
            }
            if (fpBufferLen == 0)
            {
                return audioBuffer;
            }

            audioBuffer = new byte[fpBufferLen];
            Marshal.Copy(pAudioBuffer, audioBuffer, 0, fpBufferLen);
            acr_free(pAudioBuffer);
            return audioBuffer;
        }

        /**
          *
          *  get duration from file buffer of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param filePath query file path 
          *  
          *  @return duration ms
          *
          **/
        public int GetDurationMillisecondByFile(string filePath)
        {
            return get_duration_ms_by_file(filePath);
        }

        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int create_fingerprint(byte[] pcm_buffer, int pcm_buffer_len, byte is_db_fingerprint, ref IntPtr fps_buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int create_fingerprint_by_file(string file_path, int start_time_seconds, int audio_len_seconds, byte is_db_fingerprint, ref IntPtr fps_buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int create_fingerprint_by_filebuffer(byte[] file_buffer, int file_buffer_len, int start_time_seconds, int audio_len_seconds, byte is_db_fingerprint, ref IntPtr fps_buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int decode_audio_by_file(string file_path, int start_time_seconds, int audio_len_seconds, ref IntPtr audio_buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int decode_audio_by_filebuffer(byte[] file_buffer, int file_buffer_len, int start_time_seconds, int audio_len_seconds, ref IntPtr audio_buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern void acr_free(IntPtr buffer);
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern int get_duration_ms_by_file(string file_path);
        [DllImport("libacrcloud_extr_tool.dll")]
        public static extern void acr_set_debug();
        [DllImport("libacrcloud_extr_tool.dll")]
        private static extern void acr_init();
    }

    public class ACRCloudStatusCode
    {
        public static string HTTP_ERROR = "{\"status\":{\"msg\":\"Http Error\", \"code\":3000}}";
        public static string NO_RESULT = "{\"status\":{\"msg\":\"No Result\", \"code\":1001}}";
        public static string GEN_FP_ERROR = "{\"status\":{\"msg\":\"Gen Fingerprint Error\", \"code\":2004}}";
        public static string DECODE_AUDIO_ERROR = "{\"status\":{\"msg\":\"Can not decode audio data\", \"code\":2005}}";
        public static string RECORD_ERROR = "{\"status\":{\"msg\":\"Record Error\", \"code\":2000}}";
        public static string JSON_ERROR = "{\"status\":{\"msg\":\"json error\", \"code\":2002}}";
    }

    class ACRCloudRecognizer
    {
        private string host = "";
        private string accessKey = "";
        private string accessSecret = "";
        private int timeout = 5 * 1000; // ms
        private bool debug = false;

        private ACRCloudExtrTool acrTool = new ACRCloudExtrTool();

        public ACRCloudRecognizer(IDictionary<string, Object> config)
        {
            if (config.ContainsKey("host"))
            {
                this.host = (string)config["host"];
            }
            if (config.ContainsKey("access_key"))
            {
                this.accessKey = (string)config["access_key"];
            }
            if (config.ContainsKey("access_secret"))
            {
                this.accessSecret = (string)config["access_secret"];
            }
            if (config.ContainsKey("timeout"))
            {
                this.timeout = 1000 * (int)config["timeout"];
            }
        }

        /**
          *
          *  recognize by wav audio buffer(RIFF (little-endian) data, WAVE audio, Microsoft PCM, 16 bit, mono 8000 Hz) 
          *
          *  @param wavAudioBuffer query audio buffer
          *  @param wavAudioBufferLen the length of wavAudioBuffer
          *  
          *  @return result 
          *
          **/
        public string Recognize(byte[] wavAudioBuffer, int wavAudioBufferLen)
        {
            byte[] fp = this.acrTool.CreateFingerprint(wavAudioBuffer, wavAudioBufferLen, false);
            if (fp == null)
            {
                return ACRCloudStatusCode.NO_RESULT;
            }
            return this.DoRecognize(fp);
        }

        /**
          *
          *  recognize by file path of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param filePath query file path
          *  @param startSeconds skip (startSeconds) seconds from from the beginning of (filePath)
          *  
          *  @return result 
          *
          **/
        public String RecognizeByFile(string filePath, int startSeconds)
        {
            byte[] fp = null;
            try
            {
                fp = this.acrTool.CreateFingerprintByFile(filePath, startSeconds, 12, false);
            }
            catch (Exception e)
            {
                //Console.WriteLine(e.ToString());
                return ACRCloudStatusCode.DECODE_AUDIO_ERROR;
            }

            if (fp == null)
            {
                return ACRCloudStatusCode.NO_RESULT;
            }
            return this.DoRecognize(fp);
        }

        /**
          *
          *  recognize by buffer of (Audio/Video file)
          *          Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
          *          Video: mp4, mkv, wmv, flv, ts, avi ...
          *
          *  @param fileBuffer query buffer
          *  @param fileBufferLen the length of fileBufferLen 
          *  @param startSeconds skip (startSeconds) seconds from from the beginning of fileBuffer
          *  
          *  @return result 
          *
          **/
        public String RecognizeByFileBuffer(byte[] fileBuffer, int fileBufferLen, int startSeconds)
        {
            byte[] fp = null;
            try
            {
                fp = this.acrTool.CreateFingerprintByFileBuffer(fileBuffer, fileBufferLen, startSeconds, 12, false);
            }
            catch (Exception e)
            {
                //Console.WriteLine(e.ToString());
                return ACRCloudStatusCode.DECODE_AUDIO_ERROR;
            }
            if (fp == null)
            {
                return ACRCloudStatusCode.NO_RESULT;
            }
            return this.DoRecognize(fp);
        }

        private string PostHttp(string url, IDictionary<string, Object> postParams)
        {
            string result = "";

            string BOUNDARYSTR = "acrcloud***copyright***2015***" + DateTime.Now.Ticks.ToString("x");
            string BOUNDARY = "--" + BOUNDARYSTR + "\r\n";
            var ENDBOUNDARY = Encoding.ASCII.GetBytes("--" + BOUNDARYSTR + "--\r\n\r\n");

            var stringKeyHeader = BOUNDARY +
                           "Content-Disposition: form-data; name=\"{0}\"" +
                           "\r\n\r\n{1}\r\n";
            var filePartHeader = BOUNDARY +
                            "Content-Disposition: form-data; name=\"{0}\"; filename=\"{1}\"\r\n" +
                            "Content-Type: application/octet-stream\r\n\r\n";

            var memStream = new MemoryStream();
            foreach (var item in postParams)
            {
                if (item.Value is string)
                {
                    string tmpStr = string.Format(stringKeyHeader, item.Key, item.Value);
                    byte[] tmpBytes = Encoding.UTF8.GetBytes(tmpStr);
                    memStream.Write(tmpBytes, 0, tmpBytes.Length);
                }
                else if (item.Value is byte[])
                {
                    var header = string.Format(filePartHeader, "sample", "sample");
                    var headerbytes = Encoding.UTF8.GetBytes(header);
                    memStream.Write(headerbytes, 0, headerbytes.Length);
                    byte[] sample = (byte[])item.Value;
                    memStream.Write(sample, 0, sample.Length);
                    memStream.Write(Encoding.UTF8.GetBytes("\r\n"), 0, 2);
                }
            }
            memStream.Write(ENDBOUNDARY, 0, ENDBOUNDARY.Length);

            HttpWebRequest request = null;
            HttpWebResponse response = null;
            Stream writer = null;
            StreamReader myReader = null;
            try
            {
                request = (HttpWebRequest)WebRequest.Create(url);
                request.Timeout = this.timeout;
                request.Method = "POST";
                request.ContentType = "multipart/form-data; boundary=" + BOUNDARYSTR;

                memStream.Position = 0;
                byte[] tempBuffer = new byte[memStream.Length];
                memStream.Read(tempBuffer, 0, tempBuffer.Length);

                writer = request.GetRequestStream();
                writer.Write(tempBuffer, 0, tempBuffer.Length);
                writer.Flush();
                writer.Close();
                writer = null;

                response = (HttpWebResponse)request.GetResponse();
                myReader = new StreamReader(response.GetResponseStream(), Encoding.UTF8);
                result = myReader.ReadToEnd();
            }
            catch (WebException e)
            {
                Console.WriteLine("timeout:\n" + e.ToString());
                result = ACRCloudStatusCode.HTTP_ERROR;
            }
            catch (Exception e)
            {
                Console.WriteLine("other excption:" + e.ToString());
                result = ACRCloudStatusCode.HTTP_ERROR;
            }
            finally
            {
                if (memStream != null)
                {
                    memStream.Close();
                    memStream = null;
                }
                if (writer != null)
                {
                    writer.Close();
                    writer = null;
                }
                if (myReader != null)
                {
                    myReader.Close();
                    myReader = null;
                }
                if (request != null)
                {
                    request.Abort();
                    request = null;
                }
                if (response != null)
                {
                    response.Close();
                    response = null;
                }
            }

            return result;
        }

        private string EncryptByHMACSHA1(string input, string key)
        {
            HMACSHA1 hmac = new HMACSHA1(System.Text.Encoding.UTF8.GetBytes(key));
            byte[] stringBytes = Encoding.UTF8.GetBytes(input);
            byte[] hashedValue = hmac.ComputeHash(stringBytes);
            return EncodeToBase64(hashedValue);
        }

        private string EncodeToBase64(byte[] input)
        {
            string res = Convert.ToBase64String(input, 0, input.Length);
            return res;
        }

        private string DoRecognize(byte[] queryData)
        {
            string method = "POST";
            string httpURL = "/v1/identify";
            string dataType = "fingerprint";
            string sigVersion = "1";
            string timestamp = ((int)DateTime.UtcNow.Subtract(new DateTime(1970, 1, 1, 0, 0, 0, DateTimeKind.Utc)).TotalSeconds).ToString();

            string reqURL = "http://" + host + httpURL;

            string sigStr = method + "\n" + httpURL + "\n" + accessKey + "\n" + dataType + "\n" + sigVersion + "\n" + timestamp;
            string signature = EncryptByHMACSHA1(sigStr, this.accessSecret);

            var dict = new Dictionary<string, object>();
            dict.Add("access_key", this.accessKey);
            dict.Add("sample_bytes", queryData.Length.ToString());
            dict.Add("sample", queryData);
            dict.Add("timestamp", timestamp);
            dict.Add("signature", signature);
            dict.Add("data_type", dataType);
            dict.Add("signature_version", sigVersion);

            string res = PostHttp(reqURL, dict);

            return res;
        }
    }

    public class Program
    {
        Manager m = new Manager();
        //metainfos https://docs.acrcloud.com/metadata
        public acr go(fileInput input)
        {
            var config = new Dictionary<string, object>();
            config.Add("host", "eu-west-1.api.acrcloud.com");
            config.Add("access_key", "7da0390dbe51ed34546ea918c61d41fc");
            config.Add("access_secret", "jNhWf46Snkq2SCfYlX9ebFlz9gMDT9XDXezuX03C");
            config.Add("timeout", 10); // seconds

            /**
              *   
              *  recognize by file path of (Formatter: Audio/Video)
              *     Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
              *     Video: mp4, mkv, wmv, flv, ts, avi ...
              *     
              * 
             **/
            
            ACRCloudRecognizer re = new ACRCloudRecognizer(config);



            // It will skip 0 seconds from the beginning of test.mp3.
            //string result = re.RecognizeByFile("test.mp3", 20);
            
            //Console.WriteLine(result);

            /**
              *   
              *  recognize by buffer of (Formatter: Audio/Video)
              *     Audio: mp3, wav, m4a, flac, aac, amr, ape, ogg ...
              *     Video: mp4, mkv, wmv, flv, ts, avi ...
              *     
              * 
              **/
            //var file = File.ReadAllBytes("test.mp3");




            // It will skip 0 seconds from the beginning of datas.
            var result = re.RecognizeByFileBuffer(input.bytes, input.bytes.Length, 30);
            //Console.WriteLine(result);
            result = result.Replace("}", "");
            result = result.Replace("{", "");
            result = result.Replace("\"", "");
            result = result.Replace(",", " ");

            var time = m.Between(result, "timestamp_utc", "result_type");
            if (time.StartsWith(":"))
            {
                time = time.Substring(1);
            }

            result = result.Replace(":", " ");
            acr unknown = new acr();
            unknown.album = m.Between(result, "album name", "artists");
            /*  unknown.song = m.Between(result, "title", "duration");
              char[] values = new char[]{':',',' };
              var title = m.Between(result, "title", "duration");
              unknown.duration = m.Between(result, "duration", "genres");
              var duration = m.Between(result, "duration", "genres");
              unknown.duration = unknown.duration.Replace("_ms ", "");
              duration = duration.Replace("_ms ", "");
              var ms = Convert.ToDouble(unknown.duration);
              var s = ms / 1000.0;
              unknown.duration = Math.Round(s,0) + " seconds";
              unknown.genre = m.Between(result, "genres", "acrid");
              var genre = m.Between(result, "genres", "acrid");
              var gcount = unknown.genre.Count(x => x == '[');
            unknown.artist = m.Between(result, "artists", "timestamp_utc");
            var acount = unknown.artist.Count(x => x == '[');

            
            //result = "title: " + title + "<br>";
           // result += "duration: " + duration + "<br>";
           // result += "album: " + album + "<br>";
           // result += "timestamp: " + time + "<br>";



            if (acount == 1)
            {
                unknown.artist = unknown.artist.Replace("[", "");
                unknown.artist = unknown.artist.Replace("]", "");
                unknown.artist = unknown.artist.Replace("name ", "");
                //result += "artist: " + unknown.artist + "<br>";
            }
            else
            {
                unknown.artist = unknown.artist.Replace("][", "].[");
                var artists = unknown.artist.Split('.');
                //result += "artists: ";
                for (int i = 0; i > artists.Length; i++)
                {
                    artists[i] = artists[i].Replace("[", "");
                    artists[i] = artists[i].Replace("]", "");
                    if(i == 0) { unknown.artist = artists[i] + "<br>"; }
                    unknown.artist += artists[i] + "<br>";
                }
            }
            


            if (gcount == 1)
            {
                unknown.genre = unknown.genre.Replace("[", "");
                unknown.genre = unknown.genre.Replace("]", "");
                unknown.genre = unknown.genre.Replace("name ", "");
                result += "genre: " + unknown.genre;
            }
            else
            {
                unknown.genre = unknown.genre.Replace("][", "].[");
                var genres = unknown.genre.Split('.');
                result += "genres: ";
                for (int i = 0; i > genres.Length; i++)
                {
                    genres[i] = genres[i].Replace("[", "");
                    genres[i] = genres[i].Replace("]", "");
                    if (i == 0) { unknown.genre = genres[i] + "<br>"; }
                    unknown.genre += genres[i] + "<br>";
                }
            } 
            */

            return unknown;
            //ACRCloudExtrTool acrTool = new ACRCloudExtrTool();
            //byte[] fp = acrTool.CreateFingerprintByFile("test.mp3", 80, 12, false);
            //Console.WriteLine(fp.Length);

            //byte[] audioBuffer = acrTool.DecodeAudioByFile("test.mp3", 80, 0);
            //Console.WriteLine(audioBuffer.Length);

            /*using (FileStream fs = new FileStream(@"test.mp3", FileMode.Open))
            {
                using (BinaryReader reader = new BinaryReader(fs))
                {
                    byte[] datas = reader.ReadBytes((int)fs.Length);
                    byte[] fpt = acrTool.CreateFingerprintByFileBuffer(datas, datas.Length, 80, 12, false);                
                    Console.WriteLine(fpt.Length);
                }
            }*/

            //Console.ReadLine(); 
        }
    }
}